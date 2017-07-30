package com.jeecg.pro.equipment.service.impl;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.pro.equipment.dao.UnitDao;
import com.jeecg.pro.equipment.service.UnitService;

@Service("unitService")
@Transactional
public class UnitServiceImpl extends CommonServiceImpl implements UnitService{
	private static final Logger logger = Logger.getLogger(UnitServiceImpl.class);
	@Autowired
	private UnitDao unitDao;
	@Override
	public String selectMaxNo() {
		// TODO Auto-generated method stub
		return unitDao.getMaxNO();
	}
	
}
