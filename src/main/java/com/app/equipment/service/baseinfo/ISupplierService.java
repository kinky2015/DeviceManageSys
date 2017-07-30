package com.app.equipment.service.baseinfo;

import java.util.List;

import org.jeecgframework.core.common.model.json.DataGrid;

import com.app.equipment.entity.baseinfo.SupplierEntity;

public interface ISupplierService 
{
	/**
	 * 获取所有的供应商信息
	 * @return
	 */
	public List<SupplierEntity> getSuppliers(String wheresql);
	
	/**
	 * 根据供应商编号删除供应商
	 * @param supplierNo
	 */
	public void deleteSupplier(String supplierNo);
	
	/**
	 * 根据供应商编号获取供应商信息
	 * @param supplierNo
	 * @return
	 */
	public SupplierEntity getSupplier(String supplierNo);
	
	/**
	 * 保存供应商信息
	 * @param supplier
	 */
	public void saveSupplier(SupplierEntity supplier);
	
	/**
	 * 获取分页供应商信息
	 * @param supplier
	 * @param dataGrid
	 */
	public void getPageSupplier(SupplierEntity supplier, DataGrid dataGrid);
	
	/**
	 * 批量删除供应商信息
	 * @param customerNos
	 */
	public void deleteBatch(List<String> supplierNos);
	
	/**
	 * 获取导出Excel的记录
	 * @param customer
	 * @return
	 */
	public List<SupplierEntity> getExportRecoders(SupplierEntity supplier);
	
	/**
	 * 获取客户编码
	 * @return
	 */
	public String getSupplierNo();
}
