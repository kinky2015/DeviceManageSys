package com.app.equipment.service.baseinfo;

import java.util.List;

import org.jeecgframework.core.common.model.json.DataGrid;

import com.app.equipment.entity.baseinfo.CustomerInfoEntity;

public interface ICustomerInfoService 
{
	/**
	 * 获取所有的客户信息
	 * @return
	 */
	public List<CustomerInfoEntity> getCustomers(String wheresql);
	
	/**
	 * 根据客户编号删除客户资料
	 * @param customerNo
	 */
	public void deleteCustomer(String customerNo);
	
	/**
	 * 根据客户编号获取客户资料
	 * @param customerNo
	 * @return
	 */
	public CustomerInfoEntity getCustomer(String customerNo);
	
	/**
	 * 保存客户资料
	 * @param customer
	 */
	public void saveCustomer(CustomerInfoEntity customer);
	
	/**
	 * 获取分页客户资料
	 * @param customerName
	 * @param dataGrid
	 */
	public void getPageCustomer(CustomerInfoEntity customer, DataGrid dataGrid);
	
	/**
	 * 批量删除客户资料
	 * @param customerNos
	 */
	public void deleteBatch(List<String> customerNos);
	
	/**
	 * 获取导出Excel的记录
	 * @param customer
	 * @return
	 */
	public List<CustomerInfoEntity> getExportRecoders(CustomerInfoEntity customer);
	
	/**
	 * 获取客户编码
	 * @return
	 */
	public String getCustomerNo();
}
