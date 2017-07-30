package com.jeecg.pro.equipment.entity;

public interface StatusFlag 
{
	/**
	 * 入库类型
	 */
	final static String DEV_STORAGE = "00"; //设备入库
	final static String DEV_EXPORT_STORAGE = "01"; //导入设备
	
	/**
	 * 出库类型
	 */
	final static String DEV_EXIT = "00"; //设备出库
	final static String DEV_BACK = "01"; //设备归还
}
