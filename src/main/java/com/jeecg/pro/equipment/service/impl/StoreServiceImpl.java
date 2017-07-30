package com.jeecg.pro.equipment.service.impl;

import java.util.Map;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;

import com.jeecg.pro.equipment.service.IStoreService;

@Service
public class StoreServiceImpl extends CommonServiceImpl implements IStoreService
{

	@Override
	public String getStoreNo() {
		String storeNo = "";
		Map<String, Object> result = this.commonDao.findOneForJdbc("select max(id) as id from tbl_store", null);
		if(result.get("id") == null)
		{
			storeNo = "CKNO.00000001";
		}
		else
		{
			storeNo = result.get("id").toString();
			storeNo = storeNo.replaceAll("CKNO.", "");
			long tmp = Long.parseLong(storeNo);
			tmp = tmp + 1;
			storeNo = "CKNO." + String.format("%07d", tmp);
		}
		return storeNo;
	}
	
	
}
