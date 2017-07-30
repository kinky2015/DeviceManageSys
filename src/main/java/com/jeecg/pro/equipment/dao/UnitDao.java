package com.jeecg.pro.equipment.dao;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface UnitDao {
	@Sql("SELECT Max(code) FROM tbl_units")
	String getMaxNO();
}
