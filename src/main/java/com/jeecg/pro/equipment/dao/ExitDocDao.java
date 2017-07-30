package com.jeecg.pro.equipment.dao;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;
@MiniDao
public interface ExitDocDao {
	@Sql("SELECT Count(id) FROM tbl_exit_doc")
	int selectMaxNo();
}
