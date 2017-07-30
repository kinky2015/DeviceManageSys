package com.jeecg.pro.equipment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;
/**
 * 计量单位
 * @author  lcl
 */
@Entity
@Table(name = "tbl_units")
@Inheritance(strategy = InheritanceType.JOINED)
public class Units extends IdEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5157621224047831607L;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 单位
	 */
	private String unit;
	private String remark;
	@Column(name = "code",length=100)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name = "unit",length=32)
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Column(name = "remark",length=32)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
