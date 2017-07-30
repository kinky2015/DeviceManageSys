package com.jeecg.pro.equipment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

import com.app.equipment.entity.baseinfo.SupplierEntity;

@Entity
@Table(name="tbl_device_inv")
public class DeviceInvEntity extends IdEntity
{
	/**
	 * 设备
	 */
	private DeviceEntity device;
	
	/**
	 * 仓库信息
	 */
	private StoreEntity store;
	
//	/**
//	 * 供应商
//	 */
//	private SupplierEntity supplier;
	
	/**
	 * 单个价格
	 */
	private Float price;
	
	/**
	 * 剩余量
	 */
	private Integer count;
	
	/**
	 * 总额
	 */
	private Float sumPrice;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="deviceId")
	public DeviceEntity getDevice() {
		return device;
	}

	public void setDevice(DeviceEntity device) {
		this.device = device;
	}

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="supplierId")
//	public SupplierEntity getSupplier() {
//		return supplier;
//	}
//
//	public void setSupplier(SupplierEntity supplier) {
//		this.supplier = supplier;
//	}

	@Column(name="price")
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="storeId")
	public StoreEntity getStore() {
		return store;
	}

	public void setStore(StoreEntity store) {
		this.store = store;
	}
}
