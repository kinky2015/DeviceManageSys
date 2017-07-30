package com.jeecg.pro.equipment.service;

import org.jeecgframework.core.common.service.CommonService;

public interface IDeviceService extends CommonService 
{
	/**
	 * 获取设备编号
	 * @return
	 */
	public String getDeviceCode();
}
