package com.app.equipment.dao.baseinfo;

import java.util.List;

import com.app.equipment.entity.baseinfo.SupplierEntity;

public interface ISupplierDao 
{
	/**
	 * 查询供应商信息
	 * @param wheresql
	 * @return
	 */
	public List<SupplierEntity> selects(String wheresql);
	
	/**
	 * 删除供应商信息
	 * @param supplierNo
	 */
	public void deleteBysupplierNo(String supplierNo);
	
	/**
	 * 根据供应商编号查询供应商信息
	 * @param supplierNo
	 * @return
	 */
	public SupplierEntity selectBysupplierNo(String supplierNo);
	
	/**
	 * 根据供应商编号更新供应商信息
	 * @param supplier
	 */
	public void updateBysupplierNo(SupplierEntity supplier);
	
	/**
	 * 插入供应商信息
	 * @param supplier
	 */
	public void insert(SupplierEntity supplier);
	
	/**
	 * 供应商信息总条数
	 * @param wheresql
	 * @return
	 */
	public int selectCount(String wheresql);
	
	/**
	 * 批量删除供应商信息
	 * @param supplierNos
	 */
	public void deleteBatch(List<String> supplierNos);
	
	/**
	 * 选择最大的供应商编号
	 * @return
	 */
	public String selectMaxSupplierNo();
}
