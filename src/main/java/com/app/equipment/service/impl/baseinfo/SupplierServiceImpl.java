package com.app.equipment.service.impl.baseinfo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.springframework.stereotype.Service;

import com.app.equipment.dao.baseinfo.ISupplierDao;
import com.app.equipment.entity.baseinfo.SupplierEntity;
import com.app.equipment.service.baseinfo.ISupplierService;

@Service
public class SupplierServiceImpl implements ISupplierService 
{

	@Resource(name="supplierDaoImpl")
	private ISupplierDao supplierDaoImpl;
	
	@Override
	public List<SupplierEntity> getSuppliers(String wheresql) 
	{
		// TODO Auto-generated method stub
		return supplierDaoImpl.selects(wheresql);
	}

	@Override
	public void deleteSupplier(String supplierNo) 
	{
		// TODO Auto-generated method stub
		supplierDaoImpl.deleteBysupplierNo(supplierNo);
	}

	@Override
	public SupplierEntity getSupplier(String supplierNo)
	{
		// TODO Auto-generated method stub
		return supplierDaoImpl.selectBysupplierNo(supplierNo);
	}

	@Override
	public void saveSupplier(SupplierEntity supplier) 
	{
		// TODO Auto-generated method stub
		String supplierNo = supplier.getSupplierNo();
		if(StringUtils.isEmpty(supplierNo))
		{
			supplier.setSupplierNo(this.getSupplierNo());
			supplierDaoImpl.insert(supplier);
		}
		else
		{
			supplierDaoImpl.updateBysupplierNo(supplier);
		}
	}

	@Override
	public void getPageSupplier(SupplierEntity supplier, DataGrid dataGrid)
	{
		//查询条件部分sql语句
		String wheresql = this.getWhereSql(supplier);
		
		//计算总页数
		int total = supplierDaoImpl.selectCount(wheresql);
		dataGrid.setTotal(total);
		
		//分页部分sql语句
		int minSize = (dataGrid.getPage() - 1) * dataGrid.getRows();
		int maxSize = dataGrid.getPage() * dataGrid.getRows() - 1;
		wheresql = wheresql + " limit " + minSize + "," + maxSize;
		
		//查询结果
		List<SupplierEntity> results = this.getSuppliers(wheresql);
		if(results == null)
		{
			results = new ArrayList<SupplierEntity>();
		}
		dataGrid.setResults(results);
	}

	@Override
	public void deleteBatch(List<String> supplierNos)
	{
		// TODO Auto-generated method stub
		supplierDaoImpl.deleteBatch(supplierNos);
	}
	
	/**
	 * 获取查询条件
	 * @param customer
	 * @return
	 */
	private String getWhereSql(SupplierEntity supplier)
	{
		String wheresql = "";
		String supplierName = supplier.getSupplierName();
		if(!StringUtils.isEmpty(supplierName))
		{
			wheresql = "where 1=1 " + "and supplierName like '%" + supplierName + "%'"; 
		}
		return wheresql;
	}

	@Override
	public List<SupplierEntity> getExportRecoders(SupplierEntity supplier)
	{
		// 查询where条件
		String wheresql = this.getWhereSql(supplier);
		List<SupplierEntity> results = this.getSuppliers(wheresql);
		if(results == null)
		{
			results = new ArrayList<SupplierEntity>();
		}	
		return results;
	}

	@Override
	public String getSupplierNo()
	{
		// TODO Auto-generated method stub
		String supplierNo = supplierDaoImpl.selectMaxSupplierNo();
		if(StringUtils.isEmpty(supplierNo))
		{
			supplierNo = "GNO.0000001";
		}
		else
		{
			String str = "";
			supplierNo = supplierNo.replace("GNO.", "");
			Long tmp = Long.parseLong(supplierNo);
			Long nextTmp = tmp + 1;
			int nextLength = String.valueOf(nextTmp).length();
			int length = 7 - nextLength;
			if(length != 0 )
			{
				for(int i = 0; i < length; i++)
				{
					str = str + "0";
				}
			}
			supplierNo = "GNO." + str + (tmp + 1);
		}
		return supplierNo;
	}
}
