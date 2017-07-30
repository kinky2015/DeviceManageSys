<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="deviceList" title="备件信息" checkbox="true" pagination="true" actionUrl="device.do?datagridRead" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="name" sortOrder="asc">
	<t:dgCol title="备件主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="编码" field="code" query="true"></t:dgCol>
	<t:dgCol title="设备编号" sortable="false" field="deviceNum" query="true"></t:dgCol>
	<t:dgCol title="设备名称" field="name" query="true"></t:dgCol>
	<t:dgCol title="设备规格" sortable="false" field="deviceSpec" query="false"></t:dgCol>
	<t:dgCol title="单位" field="units.unit" ></t:dgCol>
	<t:dgCol title="类别" field="tsTSCategory.name"></t:dgCol>
	<t:dgCol title="适用设备" field="suitDivce.name"></t:dgCol>
	<t:dgCol title="erp名称" field="erp.name"></t:dgCol>
	<t:dgCol title="高库存指标" field="hightItem"></t:dgCol>
	<t:dgCol title="低库存指标" field="lowItem"></t:dgCol>
	<t:dgCol title="参考价格" field="refPrice"></t:dgCol>
</t:datagrid>