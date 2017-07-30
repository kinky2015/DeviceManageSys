<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="storageDetailList" title="入库单明细记录" checkbox="true" pagination="true" actionUrl="storageDetail.do?datagridList" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="price" sortOrder="asc">
	<t:dgCol title="入库单明细主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="入库单号" field="storageDoc.storageDocNo" query="true"></t:dgCol>
	<t:dgCol title="设备编码" field="device.code" query="true"></t:dgCol>
	<t:dgCol title="设备编号" field="device.deviceNum" query="true"></t:dgCol>
	<t:dgCol title="设备名称" field="device.name" query="true"></t:dgCol>
	<t:dgCol title="设备规格" field="device.deviceSpec"></t:dgCol>
	<t:dgCol title="单位" field="device.units.unit"></t:dgCol>
	<t:dgCol title="设备类别" field="device.tsCategory.name"></t:dgCol>
	<t:dgCol title="适用设备" field="device.suitDivce.name"></t:dgCol>
	<t:dgCol title="高库存指标" field="device.hightItem"></t:dgCol>
	<t:dgCol title="低库存指标" field="device.lowItem"></t:dgCol>
	<t:dgCol title="数量" field="count"></t:dgCol>
	<t:dgCol title="供应商编号" field="supplier.supplierNo"></t:dgCol>
	<t:dgCol title="供应商名称" field="supplier.supplierName"></t:dgCol>
	<t:dgCol title="备注" field="remark"></t:dgCol>
	
	<t:dgToolBar title="导出" icon="icon-putout" funname="exportXls"></t:dgToolBar>
</t:datagrid>