package com.jeecg.pro.equipment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jeecgframework.core.common.entity.IdEntity;

@Entity
@Table(name="tbl_exit_doc")
public class ExitDocEntity extends IdEntity
{
	/**
	 * 出库单号
	 */
	private String exitDocNo;
	
	/**
	 * 出库类型
	 */
	private String exitType;
	
	/**
	 * 仓库信息
	 */
	private String storeId;
	
	/**
	 * 出库单据状态
	 */
	private String status;
	
	/**
	 * 出库人
	 */
	private String userName;
	
	/**
	 * 审核人员
	 */
	private String reviewer;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 创建人员
	 */
	private String createOperator;

	@Column(name="exitDocNo")
	public String getExitDocNo() {
		return exitDocNo;
	}

	public void setExitDocNo(String exitDocNo) {
		this.exitDocNo = exitDocNo;
	}

	@Column(name="userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="exitType")
	public String getExitType() {
		return exitType;
	}

	public void setExitType(String exitType) {
		this.exitType = exitType;
	}

	@Column(name="reviewer")
	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	@Column(name="storeId")
	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="createOperator")
	public String getCreateOperator() {
		return createOperator;
	}

	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
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
