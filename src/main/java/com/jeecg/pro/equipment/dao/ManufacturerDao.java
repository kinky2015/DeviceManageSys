package com.jeecg.pro.equipment.dao;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface ManufacturerDao {
	@Sql("SELECT Max(num) FROM tbl_manufacturer")
	String getMaxNO();
}
