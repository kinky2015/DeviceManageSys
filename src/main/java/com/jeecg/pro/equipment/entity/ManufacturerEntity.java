package com.jeecg.pro.equipment.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 生产厂商
 * @author jack
 *
 */
@Entity
@Table(name="tbl_manufacturer")
public class ManufacturerEntity extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	@Excel(name = "生产厂商编号")
	private String num;
	
	/**
	 * 名称
	 */
	@Excel(name = "生产厂商名称")
	private String name;
	
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
	 * 生产厂商地址
	 */
	@Excel(name = "地址")
	private String address;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactor() {
		return contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
