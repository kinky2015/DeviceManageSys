package com.jeecg.pro.equipment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jeecgframework.core.common.entity.IdEntity;

//@Entity
//@Table(name="tbl_stockCheck")
public class StockCheckEntity extends IdEntity
{
	/**
	 * 库存盘点编号
	 */
	private String  stockCheckNo;
	
	/**
	 * 库存量信息
	 */
	private DeviceInvEntity deviceInv;
	
	/**
	 * 期初库存
	 */
	private Integer openInvCount;
	
	/**
	 * 期末库存
	 */
	private Integer closeInvCount;
	
	/**
	 * 盈余数量
	 */
	private Integer profitCount;
	
	/**
	 * 亏损数量
	 */
	private Integer lossCount;
	
	/**
	 * 盈余金额
	 */
	private Float profitPrice;
	
	/**
	 * 亏损金额
	 */
	private Float lossPrice;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 编辑时间
	 */
	private Date modifyDate;

	@Column(name="stockCheckNo")
	public String getStockCheckNo() {
		return stockCheckNo;
	}

	public void setStockCheckNo(String stockCheckNo) {
		this.stockCheckNo = stockCheckNo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="deviceInvId")
	public DeviceInvEntity getDeviceInv() {
		return deviceInv;
	}

	public void setDeviceInv(DeviceInvEntity deviceInv) {
		this.deviceInv = deviceInv;
	}

	@Column(name="openInvCount")
	public Integer getOpenInvCount() {
		return openInvCount;
	}

	public void setOpenInvCount(Integer openInvCount) {
		this.openInvCount = openInvCount;
	}

	@Column(name="closeInvCount")
	public Integer getCloseInvCount() {
		return closeInvCount;
	}

	public void setCloseInvCount(Integer closeInvCount) {
		this.closeInvCount = closeInvCount;
	}

	@Column(name="profitCount")
	public Integer getProfitCount() {
		return profitCount;
	}

	public void setProfitCount(Integer profitCount) {
		this.profitCount = profitCount;
	}

	@Column(name="lossCount")
	public Integer getLossCount() {
		return lossCount;
	}

	public void setLossCount(Integer lossCount) {
		this.lossCount = lossCount;
	}

	@Column(name="profitPrice")
	public Float getProfitPrice() {
		return profitPrice;
	}

	public void setProfitPrice(Float profitPrice) {
		this.profitPrice = profitPrice;
	}

	@Column(name="lossPrice")
	public Float getLossPrice() {
		return lossPrice;
	}

	public void setLossPrice(Float lossPrice) {
		this.lossPrice = lossPrice;
	}

	@Temporal(TemporalType.TIMESTAMP) 
	@Column(name="createDate")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP) 
	@Column(name="modifyDate")
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}
