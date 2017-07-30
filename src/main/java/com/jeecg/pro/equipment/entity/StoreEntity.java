package com.jeecg.pro.equipment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.web.system.pojo.base.TSDepart;

@Entity
@Table(name="tbl_store")
public class StoreEntity implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7944417699205771532L;

	/**
	 * 仓库编号
	 */
	@Excel(name = "仓库编号")
	private String id;
	
	/**
	 * 仓库名称
	 */
	@Excel(name = "仓库名称")
	private String name;
	
	/**
	 * 仓库位置
	 */
	@Excel(name = "仓库位置")
	private String position;
	
	/**
	 * 公司名称
	 */
	@Excel(name = "公司名称")
	private String departName;
	
	/**
	 * 公司
	 */
	private TSDepart tsDepart;

	@Id
	@Column(name ="id",nullable=false,length=32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="position")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="departId")
	public TSDepart getTsDepart() {
		return tsDepart;
	}

	public void setTsDepart(TSDepart tsDepart) {
		this.tsDepart = tsDepart;
	}
	
	@Transient
	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}
}
