package com.app.equipment.dao.baseinfo;

import java.util.List;

import com.app.equipment.entity.baseinfo.CustomerInfoEntity;

public interface ICustomerInfoDao 
{
	/**
	 * 查询客户所有信息
	 * @return
	 */
	public List<CustomerInfoEntity> selects(String wheresql);
	
	/**
	 * 根据客户编号删除客户资料
	 * @param customerNo
	 */
	public void deleteByCustomerNo(String customerNo);
	
	/**
	 * 根据客户编号获取客户资料
	 * @param customerNo
	 * @return
	 */
	public CustomerInfoEntity selectByCustomerNo(String customerNo);
	
	/**
	 * 根据客户编号更新客户资料
	 * @param customerNo
	 */
	public void update(CustomerInfoEntity customer);
	
	/**
	 * 插入客户资料
	 * @param customer
	 */
	public void insert(CustomerInfoEntity customer);
	
	/**
	 * 总条目数
	 * @param sql
	 * @return
	 */
	public int selectCount(String sql);
	
	/**
	 * 批量删除客户资料
	 * @param customerNos
	 */
	public void deleteBatch(List<String> customerNos);
	
	/**
	 * 查询最大的客户编号
	 * @return
	 */
	public String selectMaxCustomerNo();
}
