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

@Entity
@Table(name="tbl_storage_doc")
public class StorageDocEntity extends IdEntity
{
	/**
	 * 入库单号
	 */
	private String storageDocNo;
	
	/**
	 * 入库类型
	 */
	private String storageType;
	
	/**
	 * 仓库信息
	 */
	private StoreEntity store;
	
	/**
	 * 入库人
	 */
	private String userName;
	
	/**
	 * 审核人员
	 */
	private String reviewer;
	
	/**
	 * 入库状态
	 */
	private String status;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 创建人
	 */
	private String createOperator;

	@Column(name ="storageDocNo", nullable=false, length=15)
	public String getStorageDocNo() {
		return storageDocNo;
	}

	public void setStorageDocNo(String storageDocNo) {
		this.storageDocNo = storageDocNo;
	}

	@Column(name="storageType")
	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	@Column(name="userName")
	public String getUserName() {
		return userName;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="storeId")
	public StoreEntity getStore() {
		return store;
	}

	public void setStore(StoreEntity store) {
		this.store = store;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="reviewer")
	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	@Column(name="createOperator")
	public String getCreateOperator() {
		return createOperator;
	}

	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
