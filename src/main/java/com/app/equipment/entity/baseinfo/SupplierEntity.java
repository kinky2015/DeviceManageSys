package com.app.equipment.entity.baseinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jeecgframework.poi.excel.annotation.Excel;

@Entity
@Table(name="tbl_supplier")
public class SupplierEntity 
{
	private String id;
	
	/**
	 * 编号
	 */
	@Excel(name = "供应商编号")
	private String supplierNo;
	
	/**
	 * 名称
	 */
	@Excel(name = "供应商名称")
	private String supplierName;
	
	/**
	 * 联系人
	 */
	@Excel(name = "联系人")
	private String contactor;
	
	/**
	 * 手机号码
	 */
	@Excel(name = "手机号码")
	private String telphone;
	
	/**
	 * 固定电话
	 */
	@Excel(name = "固定电话")
	private String phone;
	
	/**
	 * 税号
	 */
	@Excel(name = "税号")
	private String dutyNo;
	
	/**
	 * 开户行地址
	 */
	@Excel(name = "开户行地址")
	private String cardAddress;
	
	/**
	 * 卡号
	 */
	@Excel(name = "卡号")
	private String cardNo;
	
	/**
	 * 产品简介
	 */
	@Excel(name = "产品简介")
	private String productDesc;
	
	/**
	 * 备注
	 */
	@Excel(name = "备注")
	private String remark;

	@Transient
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name="supplierNo")
	public String getSupplierNo() {
		return supplierNo;
	}

	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}

	@Column(name="supplierName")
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Column(name="contactor")
	public String getContactor() {
		return contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	@Column(name="telphone")
	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	@Column(name="phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name="dutyNo")
	public String getDutyNo() {
		return dutyNo;
	}

	public void setDutyNo(String dutyNo) {
		this.dutyNo = dutyNo;
	}

	@Column(name="cardAddress")
	public String getCardAddress() {
		return cardAddress;
	}

	public void setCardAddress(String cardAddress) {
		this.cardAddress = cardAddress;
	}

	@Column(name="cardNo")
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Column(name="productDesc")
	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
