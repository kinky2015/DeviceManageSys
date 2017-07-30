package com.jeecg.pro.equipment.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.jeecg.pro.equipment.entity.StockCheckEntity;

public interface IStockCheckService extends CommonService
{
	/**
	 * 获取stockNo
	 * @return
	 */
	public String getStockNo();
	
	/**
	 * 获取最大的盘点编号
	 * @return
	 */
	public String getMaxStockNo();
	
	/**
	 * 创建盘点信息
	 * @param storeId
	 * @return
	 */
	public List<StockCheckEntity> createNewInfo(String storeId);
}
