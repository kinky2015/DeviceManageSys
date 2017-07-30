<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="exitDetailList" title="出库单明细记录" checkbox="true" pagination="true" actionUrl="exitDocDetail.do?datagridList" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="sumPrice" sortOrder="asc">
	<t:dgCol title="出库单明细主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="出库单号" field="exitDocDetail.exitDoc.exitDocNo" query="true"></t:dgCol>
	<t:dgCol title="设备编码" field="exitDocDetail.device.code" query="true"></t:dgCol>
	<t:dgCol title="设备编号" field="exitDocDetail.device.deviceNum" query="true"></t:dgCol>
	<t:dgCol title="设备编号" field="exitDocDetail.device.name" query="true"></t:dgCol>
	<t:dgCol title="设备规格" field="exitDocDetail.device.deviceSpec" query="true"></t:dgCol>
	<t:dgCol title="单位" field="exitDocDetail.device.units.unit"></t:dgCol>
	<t:dgCol title="设备类别" field="exitDocDetail.device.tsCategory.name"></t:dgCol>
	<t:dgCol title="适用设备" field="exitDocDetail.device.suitDivce.name"></t:dgCol>
	<t:dgCol title="高库存指标" field="exitDocDetail.device.hightItem"></t:dgCol>
	<t:dgCol title="低库存指标" field="exitDocDetail.device.lowItem"></t:dgCol>
	<t:dgCol title="供应商编号" field="supplier.supplierNo" query="true"></t:dgCol>
	<t:dgCol title="供应商名称" field="supplier.supplierName"></t:dgCol>
	<t:dgCol title="数量" field="count"></t:dgCol>
	<t:dgCol title="申请部门" field="exitDocDetail.tsDepart.departname"></t:dgCol>
	<t:dgCol title="申请人" field="exitDocDetail.tsUser.userName"></t:dgCol>
	<t:dgCol title="申请原因" field="reason"></t:dgCol>
	<t:dgCol title="备注" field="remark"></t:dgCol>
	<t:dgToolBar title="导出" icon="icon-putout" funname="exportXls"></t:dgToolBar>
</t:datagrid>