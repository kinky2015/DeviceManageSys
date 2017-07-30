package com.jeecg.pro.equipment.dao;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface MaintenanceDao {
	@Sql("SELECT Max(num) FROM tbl_maintenance")
	String getMaxNO();
}
