package com.app.equipment.dao.impl.baseinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.equipment.dao.baseinfo.ISupplierDao;
import com.app.equipment.entity.baseinfo.SupplierEntity;
import com.app.equipment.tools.StringTools;

@Repository
public class SupplierDaoImpl implements ISupplierDao
{

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<SupplierEntity> selects(String wheresql) 
	{
		// TODO Auto-generated method stub
		List<SupplierEntity> suppliers = new ArrayList<SupplierEntity>();
		String sql = "select * from tbl_supplier " + wheresql;
		List<Map<String, Object>> results = this.jdbcTemplate.queryForList(sql);
		if(results != null)
		{
			for(Map<String, Object> result : results)
			{
				SupplierEntity supplier = new SupplierEntity();
				
				supplier.setId(result.get("supplierNo").toString());
				supplier.setSupplierNo(result.get("supplierNo").toString());
				supplier.setSupplierName(StringTools.obj2String(result.get("supplierName")));
				supplier.setContactor(StringTools.obj2String(result.get("contactor")));
				supplier.setTelphone(StringTools.obj2String(result.get("telphone")));
				supplier.setPhone(StringTools.obj2String(result.get("phone")));
				supplier.setDutyNo(StringTools.obj2String(result.get("dutyNo")));
				supplier.setCardAddress(StringTools.obj2String(result.get("cardAddress")));
				supplier.setCardNo(StringTools.obj2String(result.get("cardNo")));
				supplier.setProductDesc(StringTools.obj2String(result.get("productDesc")));
				supplier.setRemark(StringTools.obj2String(result.get("remark")));
				
				suppliers.add(supplier);
			}
		}
		return suppliers;
	}

	@Override
	public void deleteBysupplierNo(String supplierNo) 
	{
		// TODO Auto-generated method stub
		String sql = "delete from tbl_supplier where supplierNo = '" + supplierNo + "'";
		jdbcTemplate.execute(sql);
	}

	@Override
	public SupplierEntity selectBysupplierNo(String supplierNo) 
	{
		// TODO Auto-generated method stub
		String sql = "select * from tbl_supplier where supplierNo = '" + supplierNo + "'";
		Map<String, Object> result = this.jdbcTemplate.queryForMap(sql);
		SupplierEntity supplier = new SupplierEntity();
		supplier.setId(result.get("supplierNo").toString());
		supplier.setSupplierNo(result.get("supplierNo").toString());
		supplier.setSupplierName(StringTools.obj2String(result.get("supplierName")));
		supplier.setContactor(StringTools.obj2String(result.get("contactor")));
		supplier.setTelphone(StringTools.obj2String(result.get("telphone")));
		supplier.setPhone(StringTools.obj2String(result.get("phone")));
		supplier.setDutyNo(StringTools.obj2String(result.get("dutyNo")));
		supplier.setCardAddress(StringTools.obj2String(result.get("cardAddress")));
		supplier.setCardNo(StringTools.obj2String(result.get("cardNo")));
		supplier.setProductDesc(StringTools.obj2String(result.get("productDesc")));
		supplier.setRemark(StringTools.obj2String(result.get("remark")));
		return supplier;
	}

	@Override
	public void updateBysupplierNo(SupplierEntity supplier) 
	{
		// TODO Auto-generated method stub
		String sql = "update "
						+ "tbl_supplier "
				   + "set "
				   		+ "supplierName = ?, "
				   		+ "contactor = ?, "
				   		+ "telphone = ?, "
				   		+ "phone = ?, "
				   		+ "dutyNo = ?, "
				   		+ "cardAddress = ?, "
				   		+ "cardNo = ?, "
				   		+ "productDesc = ?, "
				   		+ "remark = ?"
				   + " where "
						+ "supplierNo = ?";
		Object[] supplierInfo = new Object[]
		{
			supplier.getSupplierName(),
			supplier.getContactor(),
			supplier.getTelphone(),
			supplier.getPhone(),
			supplier.getDutyNo(),
			supplier.getCardAddress(),
			supplier.getCardNo(),
			supplier.getProductDesc(),
			supplier.getRemark(),
			supplier.getSupplierNo()
		};
		this.jdbcTemplate.update(sql, supplierInfo);
	}

	@Override
	public void insert(SupplierEntity supplier) 
	{
		// TODO Auto-generated method stub
		String sql = "insert into tbl_supplier"
					+ "("
						+ "supplierNo, "
						+ "supplierName, "
						+ "contactor, "
						+ "telphone, "
						+ "phone, "
						+ "dutyNo, "
						+ "cardAddress, "
						+ "cardNo, "
						+ "productDesc, "
						+ "remark"
						+ ") "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] supplierInfo = new Object[]
		{
			supplier.getSupplierNo(),
			supplier.getSupplierName(),
			supplier.getContactor(),
			supplier.getTelphone(),
			supplier.getPhone(),
			supplier.getDutyNo(),
			supplier.getCardAddress(),
			supplier.getCardNo(),
			supplier.getProductDesc(),
			supplier.getRemark()
		};
		this.jdbcTemplate.update(sql, supplierInfo);
	}

	@Override
	public int selectCount(String wheresql) {
		// TODO Auto-generated method stub
		String sql = "select * from tbl_supplier " + wheresql;
		List<Map<String, Object>> results = this.jdbcTemplate.queryForList(sql);
		if(results == null)
		{
			return 0;
		}
		return results.size();
	}

	@Override
	public void deleteBatch(List<String> supplierNos) {
		// TODO Auto-generated method stub
		String sql = "delete from tbl_supplier where supplierNo in (";
		String supplierStr = "";
		for(String supplierNo : supplierNos)
		{
			supplierStr = supplierStr + ", '" + supplierNo + "'";
		}
		supplierStr = supplierStr.substring(1, supplierStr.length());
		sql = sql + supplierStr + ");";
		
		this.jdbcTemplate.execute(sql);
	}

	@Override
	public String selectMaxSupplierNo() {
		// TODO Auto-generated method stub
		String sql = "select max(supplierNo) from tbl_supplier";
		String result = this.jdbcTemplate.queryForObject(sql, String.class);
		return result;
	}

}
