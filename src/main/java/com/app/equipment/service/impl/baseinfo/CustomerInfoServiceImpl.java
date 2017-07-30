package com.app.equipment.service.impl.baseinfo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.springframework.stereotype.Service;

import com.app.equipment.dao.baseinfo.ICustomerInfoDao;
import com.app.equipment.entity.baseinfo.CustomerInfoEntity;
import com.app.equipment.service.baseinfo.ICustomerInfoService;

@Service
public class CustomerInfoServiceImpl implements ICustomerInfoService 
{

	@Resource(name="customerInfoDaoImpl")
	private ICustomerInfoDao customerInfoDaoImpl;
	
	@Override
	public List<CustomerInfoEntity> getCustomers(String wheresql) 
	{
		// TODO Auto-generated method stub
		return customerInfoDaoImpl.selects(wheresql);
	}

	@Override
	public void deleteCustomer(String customerNo) 
	{
		// TODO Auto-generated method stub
		customerInfoDaoImpl.deleteByCustomerNo(customerNo);
	}

	@Override
	public CustomerInfoEntity getCustomer(String customerNo) 
	{
		// TODO Auto-generated method stub
		return customerInfoDaoImpl.selectByCustomerNo(customerNo);
	}

	@Override
	public void saveCustomer(CustomerInfoEntity customer) 
	{
		// TODO Auto-generated method stub
		String customerNo = customer.getCustomerNo();
		if(StringUtils.isEmpty(customerNo))
		{
			customer.setCustomerNo(this.getCustomerNo());
			customerInfoDaoImpl.insert(customer);
		}
		else
		{
			customerInfoDaoImpl.update(customer);
		}
	}

	@Override
	public void getPageCustomer(CustomerInfoEntity customer, DataGrid dataGrid) 
	{
		//查询条件部分sql语句
		String wheresql = this.getWhereSql(customer);
		
		//计算总页数
		int total = customerInfoDaoImpl.selectCount(wheresql);
		dataGrid.setTotal(total);
		
		//分页部分sql语句
		int minSize = (dataGrid.getPage() - 1) * dataGrid.getRows();
		int maxSize = dataGrid.getPage() * dataGrid.getRows() - 1;
		wheresql = wheresql + " limit " + minSize + "," + maxSize;
		
		//查询结果
		List<CustomerInfoEntity> results = this.getCustomers(wheresql);
		if(results == null)
		{
			results = new ArrayList<CustomerInfoEntity>();
		}
		dataGrid.setResults(results);
	}

	@Override
	public void deleteBatch(List<String> customerNos) 
	{
		// TODO Auto-generated method stub
		customerInfoDaoImpl.deleteBatch(customerNos);
	}
	
	/**
	 * 获取查询条件
	 * @param customer
	 * @return
	 */
	private String getWhereSql(CustomerInfoEntity customer)
	{
		String wheresql = "";
		String customerName = customer.getCustomerName();
		if(!StringUtils.isEmpty(customerName))
		{
			wheresql = "where 1=1 " + "and customerName like '%" + customerName + "%'"; 
		}
		return wheresql;
	}

	@Override
	public List<CustomerInfoEntity> getExportRecoders(CustomerInfoEntity customer) 
	{
		// 查询where条件
		String wheresql = this.getWhereSql(customer);
		List<CustomerInfoEntity> results = this.getCustomers(wheresql);
		if(results == null)
		{
			results = new ArrayList<CustomerInfoEntity>();
		}	
		return results;
	}

	@Override
	public String getCustomerNo() 
	{
		// TODO Auto-generated method stub
		String customerNo = customerInfoDaoImpl.selectMaxCustomerNo();
		if(StringUtils.isEmpty(customerNo))
		{
			customerNo = "NO.0000001";
		}
		else
		{
			String str = "";
			customerNo = customerNo.replace("NO.", "");
			Long tmp = Long.parseLong(customerNo);
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
			customerNo = "NO." + str + (tmp + 1);
		}
		return customerNo;
	}
}
