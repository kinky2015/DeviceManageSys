package com.jeecg.pro.equipment.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;

import com.jeecg.pro.equipment.entity.DeviceInvEntity;
import com.jeecg.pro.equipment.entity.StockCheckEntity;
import com.jeecg.pro.equipment.service.IStockCheckService;

@Service("stockCheckServiceImpl")
public class StockCheckServiceImpl extends CommonServiceImpl implements IStockCheckService
{

	@Override
	public List<StockCheckEntity> createNewInfo(String storeId) 
	{
		//根据storeId获取该仓库的设备库存信息
		List<DeviceInvEntity> deviceInvs = this.commonDao.findByProperty(DeviceInvEntity.class, "store.id", storeId);
		if(deviceInvs != null && deviceInvs.size() >= 0)
		{
			List<StockCheckEntity> stockChecks = new ArrayList<StockCheckEntity>();
			
			//获取已经盘点的最大盘点编号
			String stockMaxNo = this.getMaxStockNo();
			
			//获取盘点编号
			String stockNo = this.getStockNo();
			
			if(StringUtils.isEmpty(stockMaxNo))
			{
				for(DeviceInvEntity deviceInv : deviceInvs)
				{
					StockCheckEntity stockCheck = new StockCheckEntity();
					stockCheck.setId(UUID.randomUUID().toString());
					stockCheck.setStockCheckNo(stockNo);
					stockCheck.setDeviceInv(deviceInv);

					stockChecks.add(stockCheck);
				}
			}
			else
			{
				List<StockCheckEntity> queryStocks = this.commonDao.findByProperty(StockCheckEntity.class, "stockCheckNo", stockMaxNo);
				Map<String, StockCheckEntity> stockMap = this.constructMap(queryStocks);
				for(DeviceInvEntity deviceInv : deviceInvs)
				{
					String deviceId = deviceInv.getId();
					if(stockMap.containsKey(deviceId))
					{
						StockCheckEntity stock = stockMap.get(deviceId);
						
						//必须要有这个临时对象不然的话，在原有查询出来的记录上修改，会直接改掉数据库，应该是个bug
						StockCheckEntity tmp = new StockCheckEntity();
						tmp.setId(UUID.randomUUID().toString());
						tmp.setDeviceInv(stock.getDeviceInv());
						tmp.setStockCheckNo(stockNo);
						tmp.setOpenInvCount(stock.getCloseInvCount());
						tmp.setCloseInvCount(null);
						tmp.setProfitCount(null);
						tmp.setLossPrice(null);
						tmp.setLossCount(null);
						tmp.setLossPrice(null);
						stockChecks.add(tmp);
					}
					else
					{
						StockCheckEntity stock = new StockCheckEntity();
						stock.setId(UUID.randomUUID().toString());
						stock.setDeviceInv(deviceInv);
						stock.setStockCheckNo(stockNo);
						stock.setOpenInvCount(0);
						stockChecks.add(stock);
					}
				}
			}
			return stockChecks;
		}
		
		return new ArrayList<StockCheckEntity>();
	}
	
	private Map<String, StockCheckEntity> constructMap(List<StockCheckEntity> stocks)
	{
		Map<String, StockCheckEntity> result = new HashMap<String, StockCheckEntity>();
		for(StockCheckEntity stock : stocks)
		{
			String devInvId = stock.getDeviceInv().getId();
			result.put(devInvId, stock);
		}
		return result;
	}

	@Override
	public String getStockNo() 
	{
		// TODO Auto-generated method stub

		String stockNo = "";
		Map<String, Object> result = this.commonDao.findOneForJdbc("select max(stockCheckNo) as stockCheckNo from tbl_stockCheck", null);
		if(result.get("stockCheckNo") == null)
		{
			stockNo = "PDNO.0000001";
		}
		else
		{
			stockNo = result.get("stockCheckNo").toString();
			stockNo = stockNo.replaceAll("PDNO.", "");
			long tmp = Long.parseLong(stockNo);
			tmp = tmp + 1;
			stockNo = "PDNO." + String.format("%07d", tmp);
		}
		return stockNo;
	}

	@Override
	public String getMaxStockNo() {
		String stockNo = "";
		Map<String, Object> result = this.commonDao.findOneForJdbc("select max(stockCheckNo) as stockCheckNo from tbl_stockCheck", null);
		if(result.get("stockCheckNo") == null)
		{
			stockNo = "";
		}
		else
		{
			stockNo = result.get("stockCheckNo").toString();
		}
		
		return stockNo;
	}

}
