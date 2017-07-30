package com.jeecg.pro.equipment.service;

import org.jeecgframework.core.common.service.CommonService;

public interface IExitDocService extends CommonService
{
	public String getExitDocNo();

	public int selectMaxNo();
}
