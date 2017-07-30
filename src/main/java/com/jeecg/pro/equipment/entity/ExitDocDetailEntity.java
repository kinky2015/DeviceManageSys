package com.jeecg.pro.equipment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jeecgframework.core.common.entity.IdEntity;

@Entity
@Table(name="tbl_exit_detail")
public class ExitDocDetailEntity extends IdEntity
{
	/**
	 * 出库单信息
	 */
	private String exitDocNo;

	/**
	 * 仓库Id
	 */
	private String storeId;
	
	/**
	 * 设备信息
	 */
	private String deviceId;
	
	/**
	 * 出库数量
	 */
	private Integer count;
	
	/**
	 * 总价格
	 */
	private Float sumPrice;
	
	/**
	 * 申请原因
	 */
	private String reason;

	/**
	 * 在页面中选择的供应商、单价、数量、金额
	 */
	private String selectSupplier;
	private String selectPrice;
	private String selectCount;
	private String selectSumPrice;
	private String selectDevInv;

	@Column(name="count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name="sumPrice")
	public Float getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Float sumPrice) {
		this.sumPrice = sumPrice;
	}

	@Column(name="exitDocNo")
	public String getExitDocNo() {
		return exitDocNo;
	}

	public void setExitDocNo(String exitDocNo) {
		this.exitDocNo = exitDocNo;
	}

	@Column(name="storeId")
	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	@Column(name="deviceId")
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name="reason")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Transient
	public String getSelectSupplier() {
		return selectSupplier;
	}

	public void setSelectSupplier(String selectSupplier) {
		this.selectSupplier = selectSupplier;
	}

	@Transient
	public String getSelectPrice() {
		return selectPrice;
	}

	public void setSelectPrice(String selectPrice) {
		this.selectPrice = selectPrice;
	}

	@Transient
	public String getSelectCount() {
		return selectCount;
	}

	public void setSelectCount(String selectCount) {
		this.selectCount = selectCount;
	}

	@Transient
	public String getSelectSumPrice() {
		return selectSumPrice;
	}

	public void setSelectSumPrice(String selectSumPrice) {
		this.selectSumPrice = selectSumPrice;
	}

	@Transient
	public String getSelectDevInv() {
		return selectDevInv;
	}

	public void setSelectDevInv(String selectDevInv) {
		this.selectDevInv = selectDevInv;
	}
}
