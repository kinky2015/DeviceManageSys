package com.jeecg.pro.equipment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

@Entity
@Table(name="tbl_storage_detail")
public class StorageDetailEntity extends IdEntity
{
	/**
	 * 入库单号
	 */
	private StorageDocEntity doc;
	
	/**
	 * 仓库信息
	 */
	private StoreEntity store;
	
	/**
	 * 入库设备
	 */
	private DeviceEntity device;
	
	/**
	 * 入库数量
	 */
	private Integer count;
	
	/**
	 * 库存总价格
	 */
	private Float sumPrice;
	
	/**
	 * 备注
	 */
	private String remark;

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

	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="docId")
	public StorageDocEntity getDoc() {
		return doc;
	}

	public void setDoc(StorageDocEntity doc) {
		this.doc = doc;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="storeId")
	public StoreEntity getStore() {
		return store;
	}

	public void setStore(StoreEntity store) {
		this.store = store;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="deviceId")
	public DeviceEntity getDevice() {
		return device;
	}

	public void setDevice(DeviceEntity device) {
		this.device = device;
	}
}
