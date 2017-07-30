package com.app.equipment.dao.impl.baseinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.equipment.dao.baseinfo.ICustomerInfoDao;
import com.app.equipment.entity.baseinfo.CustomerInfoEntity;
import com.app.equipment.tools.StringTools;

@Repository
public class CustomerInfoDaoImpl implements ICustomerInfoDao
{

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CustomerInfoEntity> selects(String wheresql) 
	{
		// TODO Auto-generated method stub
		List<CustomerInfoEntity> customers = new ArrayList<CustomerInfoEntity>();
		
		String sql = "select * from tbl_customer " + wheresql;
		List<Map<String, Object>> results = this.jdbcTemplate.queryForList(sql);
		if(results != null)
		{
			for(Map<String, Object> result : results)
			{
				CustomerInfoEntity customer = new CustomerInfoEntity();
				customer.setId(result.get("customerNo").toString());
				customer.setCustomerNo(result.get("customerNo").toString());
				customer.setCustomerName(StringTools.obj2String(result.get("customerName")));
				customer.setPhone(StringTools.obj2String(result.get("phone")));
				customer.setTelphone(StringTools.obj2String(result.get("telphone")));
				customer.setContactor(StringTools.obj2String(result.get("contactor")));
				customer.setProduct(StringTools.obj2String(result.get("product")));
				customer.setAddress(StringTools.obj2String(result.get("address")));
				customer.setOptions(StringTools.obj2String(result.get("options")));
				customer.setRemark(StringTools.obj2String(result.get("remark")));
				
				customers.add(customer);
			}
		}
		
		return customers;
	}

	@Override
	public void deleteByCustomerNo(String customerNo) 
	{
		// TODO Auto-generated method stub
		String sql = "delete from tbl_customer where customerNo = '" + customerNo + "'";
		this.jdbcTemplate.execute(sql);
	}

	@Override
	public CustomerInfoEntity selectByCustomerNo(String customerNo) 
	{
		// TODO Auto-generated method stub
		String sql = "select * from tbl_customer where customerNo= '" + customerNo +"'";
		Map<String, Object> result = this.jdbcTemplate.queryForMap(sql);
		CustomerInfoEntity customer = new CustomerInfoEntity();
		customer.setId(result.get("customerNo").toString());
		customer.setCustomerNo(result.get("customerNo").toString());
		customer.setCustomerName(StringTools.obj2String(result.get("customerName")));
		customer.setPhone(StringTools.obj2String(result.get("phone")));
		customer.setTelphone(StringTools.obj2String(result.get("telphone")));
		customer.setContactor(StringTools.obj2String(result.get("contactor")));
		customer.setProduct(StringTools.obj2String(result.get("product")));
		customer.setAddress(StringTools.obj2String(result.get("address")));
		customer.setOptions(StringTools.obj2String(result.get("options")));
		customer.setRemark(StringTools.obj2String(result.get("remark")));
		return customer;
	}

	@Override
	public void update(CustomerInfoEntity customer) 
	{
		// TODO Auto-generated method stub
		String sql = "update "
						+ "tbl_customer "
					+ "set "
						+ "customerName = ?,"
						+ "phone = ?,"
						+ "telphone = ?,"
						+ "contactor = ?,"
						+ "product = ?,"
						+ "address = ?,"
						+ "options = ?,"
						+ "remark = ? "
					+ "where "
						+ "customerNo = ?";
		Object[] customerInfo = new Object[]
		{
			customer.getCustomerName(),
			customer.getPhone(),
			customer.getTelphone(),
			customer.getContactor(),
			customer.getProduct(),
			customer.getAddress(),
			customer.getOptions(),
			customer.getRemark(),
			customer.getCustomerNo()
		};
		this.jdbcTemplate.update(sql, customerInfo);
	}

	@Override
	public void insert(CustomerInfoEntity customer) 
	{
		// TODO Auto-generated method stub
		String sql = "insert into tbl_customer"
					+ "("
						+ "customerNo,"
						+ "customerName,"
						+ "phone,"
						+ "telphone,"
						+ "contactor,"
						+ "product,"
						+ "address,"
						+ "options,"
						+ "remark"
					+ ") "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] customerInfo = new Object[]
		{
			customer.getCustomerNo(),
			customer.getCustomerName(),
			customer.getPhone(),
			customer.getTelphone(),
			customer.getContactor(),
			customer.getProduct(),
			customer.getAddress(),
			customer.getOptions(),
			customer.getRemark()
		};
		this.jdbcTemplate.update(sql, customerInfo);
	}

	@Override
	public int selectCount(String wheresql) 
	{
		// TODO Auto-generated method stub	
		String sql = "select * from tbl_customer " + wheresql;
		List<Map<String, Object>> results = this.jdbcTemplate.queryForList(sql);
		if(results == null)
		{
			return 0;
		}
		return results.size();
	}

	@Override
	public void deleteBatch(List<String> customerNos) 
	{
		// TODO Auto-generated method stub
		String sql = "delete from tbl_customer where customerNo in (";
		String customerStr = "";
		for(String customerNo : customerNos)
		{
			customerStr = customerStr + ", '" + customerNo + "'";
		}
		customerStr = customerStr.substring(1, customerStr.length());
		sql = sql + customerStr + ");";
		
		this.jdbcTemplate.execute(sql);
	}

	@Override
	public String selectMaxCustomerNo() 
	{
		// TODO Auto-generated method stub
		String sql = "select max(customerNo) from tbl_customer";
		String result = this.jdbcTemplate.queryForObject(sql, String.class);
		return result;
	}

}
