package com.app.equipment.entity.baseinfo;

import org.jeecgframework.poi.excel.annotation.Excel;

public class CustomerInfoEntity 
{
	private String id;
	
	/**
	 * 客户编码
	 */
	@Excel(name = "客户编码")
	private String customerNo;
	
	/**
	 * 客户名称
	 */
	@Excel(name = "客户名称")
	private String customerName;
	
	/**
	 * 客户固定电话
	 */
	@Excel(name = "固定电话")
	private String phone;
	
	/**
	 * 客户手机号
	 */
	@Excel(name = "手机号")
	private String telphone;
	
	/**
	 * 联系人
	 */
	@Excel(name = "联系人")
	private String contactor;
	
	/**
	 * 客户意向产品
	 */
	@Excel(name = "意向产品")
	private String product;
	
	/**
	 * 客户地址
	 */
	@Excel(name = "地址")
	private String address;
	
	/**
	 * 附件
	 */
	@Excel(name = "附件")
	private String options;
	
	/**
	 * 备注
	 */
	@Excel(name = "备注")
	private String remark;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getContactor() {
		return contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
