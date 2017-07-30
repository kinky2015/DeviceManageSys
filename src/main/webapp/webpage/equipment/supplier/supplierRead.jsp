<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="supplierList" title="供应商资料" checkbox="true" pagination="true" actionUrl="supplier.do?datagridRead" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="supplierName" sortOrder="asc">
	<t:dgCol title="供应商编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="供应商编号" field="supplierNo"></t:dgCol>
	<t:dgCol title="供应商名称" sortable="false" field="supplierName" query="true"></t:dgCol>
	<t:dgCol title="联系人" field="contactor" ></t:dgCol>
	<t:dgCol title="供应商手机号" sortable="false" field="telphone" query="false"></t:dgCol>
	<t:dgCol title="供应商固定电话" field="phone" query="false"></t:dgCol>
	<t:dgCol title="税号" field="dutyNo"></t:dgCol>
	<t:dgCol title="开户行地址" field="cardAddress"></t:dgCol>
	<t:dgCol title="卡号" field="cardNo"></t:dgCol>
	<t:dgCol title="产品简介" field="productDesc"></t:dgCol>
	<t:dgCol title="备注" field="remark"></t:dgCol>
</t:datagrid>