package com.jeecg.pro.equipment.entity;

import java.io.Serializable;
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
import org.jeecgframework.web.system.pojo.base.TSCategoryEntity;
import org.jeecgframework.web.system.pojo.base.TSType;

import com.app.equipment.entity.baseinfo.SupplierEntity;

@Entity
@Table(name="tbl_device")
public class DeviceEntity extends IdEntity implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8942504692032795545L;
	/**
	 * 设备名称
	 */
	private String name;
	/**
	 * 设备类别
	 */
	private TSCategoryEntity  tsCategory;
	/**
	 * 设备编码
	 */
	private String code;
	
	/**
	 * 设备编号
	 */
	private String deviceNum;
	/**
	 * 财务资产卡片编号（财务填写）
	 */
	private String assetNum;
	/**
	 * 存放地点
	 */
	private String store;
	/**
	 * 设备规格
	 */
	private String deviceSpec;
	/**
	 * 生产厂家
	 */
	private ManufacturerEntity manufacturer;
	/**
	 * 供应商
	 */
	private SupplierEntity supplier;
	/**
	 * 维修厂商
	 */
	private MaintenanceEntity maintenance;
	/**
	 * 合同名称
	 */
	private String contractName;
	/**
	 * 技术参数
	 */
	private String technicalParam;
	/**
	 * 合同编号
	 */
	private String contractNum;
	/**
	 * 单位
	 */
	private Units units;
	/**
	 * 单价
	 */
	private Double unitPrice;
	/**
	 * 实物管理部门
	 */
	private String objDepart;
	/**
	 * 实物管理部门责任人
	 */
	private String zrUser;
	/**
	 * 使用保管部门
	 */
	private String useDepart;
	/**
	 * 使用保管部门责任人
	 */
	private String useUser;
	/**
	 * 验收人
	 */
	private String ysUser;
	/**
	 * 资产增加方式
	 */
	private String zczjfs;
	/**
	 * 启用日期
	 */
	private Date qyDate;
	/**
	 * 资产使用状况
	 */
	private String tStype;
	/**
	 * 出厂日期
	 */
	private Date ccDate;
	/**
	 * 购置日期
	 */
	private Date buyDate;
	/**
	 * 出厂编号
	 */
	private String outNum;
	/**
	 * 资金源头
	 */
	private String capital;
//	/**
//	 *用途分类
//	 */
//	private TSType usetype;
	/**
	 * 附属设备
	 */
	private DeviceEntity parentDevice;
	
	/**
	 * 设备状态
	 */
	private String status;
	
	@Column(name="code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="deviceSpec")
	public String getDeviceSpec() {
		return deviceSpec;
	}

	public void setDeviceSpec(String deviceSpec) {
		this.deviceSpec = deviceSpec;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="unitId")
	public Units getUnits() {
		return units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="categoryId")
	public TSCategoryEntity getTsCategory() {
		return tsCategory;
	}

	public void setTsCategory(TSCategoryEntity tsCategory) {
		this.tsCategory = tsCategory;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="parentId")
	public DeviceEntity getParentDevice() {
		return parentDevice;
	}

	public void setParentDevice(DeviceEntity parentDevice) {
		this.parentDevice = parentDevice;
	}

	@Column(name="assetNum")
	public String getAssetNum() {
		return assetNum;
	}

	public void setAssetNum(String assetNum) {
		this.assetNum = assetNum;
	}

	@Column(name="store")
	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	@Column(name="contractName")
	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	@Column(name="technicalParam")
	public String getTechnicalParam() {
		return technicalParam;
	}

	public void setTechnicalParam(String technicalParam) {
		this.technicalParam = technicalParam;
	}

	@Column(name="contractNum")
	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	@Column(name="unitPrice")
	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name="zczjfs")
	public String getZczjfs() {
		return zczjfs;
	}

	public void setZczjfs(String zczjfs) {
		this.zczjfs = zczjfs;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="qyDate")
	public Date getQyDate() {
		return qyDate;
	}

	public void setQyDate(Date qyDate) {
		this.qyDate = qyDate;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="manufacturerId")
	public ManufacturerEntity getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerEntity manufacturer) {
		this.manufacturer = manufacturer;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="supplierId")
	public SupplierEntity getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="maintenanceId")
	public MaintenanceEntity getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(MaintenanceEntity maintenance) {
		this.maintenance = maintenance;
	}

	@Column(name="objDepart")
	public String getObjDepart() {
		return objDepart;
	}

	public void setObjDepart(String objDepart) {
		this.objDepart = objDepart;
	}

	@Column(name="zrUser")
	public String getZrUser() {
		return zrUser;
	}

	public void setZrUser(String zrUser) {
		this.zrUser = zrUser;
	}

	@Column(name="useDepart")
	public String getUseDepart() {
		return useDepart;
	}

	public void setUseDepart(String useDepart) {
		this.useDepart = useDepart;
	}

	@Column(name="useUser")
	public String getUseUser() {
		return useUser;
	}

	public void setUseUser(String useUser) {
		this.useUser = useUser;
	}

	@Column(name="ysUser")
	public String getYsUser() {
		return ysUser;
	}

	public void setYsUser(String ysUser) {
		this.ysUser = ysUser;
	}

	@Column(name="tStypeId")
	public String gettStype() {
		return tStype;
	}

	public void settStype(String tStype) {
		this.tStype = tStype;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="ccDate")
	public Date getCcDate() {
		return ccDate;
	}

	public void setCcDate(Date ccDate) {
		this.ccDate = ccDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="buyDate")
	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	@Column(name="outNum")
	public String getOutNum() {
		return outNum;
	}

	public void setOutNum(String outNum) {
		this.outNum = outNum;
	}

	@Column(name="capital")
	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "usetypeid")
//	public TSType getUsetype() {
//		return usetype;
//	}
//
//	public void setUsetype(TSType usetype) {
//		this.usetype = usetype;
//	}

	@Column(name="deviceNum")
	public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
