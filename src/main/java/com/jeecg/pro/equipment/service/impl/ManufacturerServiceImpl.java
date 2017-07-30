package com.jeecg.pro.equipment.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.pro.equipment.dao.ManufacturerDao;
import com.jeecg.pro.equipment.service.IManufacturerService;
/**
 * 生产厂商
 * @author jack
 *
 */
@Service("manufacturerService")
@Transactional
public class ManufacturerServiceImpl  extends CommonServiceImpl implements IManufacturerService{
	@Autowired
	private ManufacturerDao manufacturerDao;
	@Override
	public String selectMaxNo() {
		// TODO Auto-generated method stub
		return manufacturerDao.getMaxNO();
	}

}
