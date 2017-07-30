package com.jeecg.pro.equipment.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.pro.equipment.dao.MaintenanceDao;
import com.jeecg.pro.equipment.service.IMaintenanceService;
/**
 * 维修厂商
 * @author jack
 *
 */
@Service("maintenanceService")
@Transactional
public class MaintenanceServiceImpl extends CommonServiceImpl implements IMaintenanceService{
	@Autowired
	private MaintenanceDao maintenanceDao;
	@Override
	public String selectMaxNo() {
		// TODO Auto-generated method stub
		return maintenanceDao.getMaxNO();
	}
}
