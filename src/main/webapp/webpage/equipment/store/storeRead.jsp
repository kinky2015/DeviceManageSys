<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="storeList" title="仓库信息管理" checkbox="true" pagination="true" actionUrl="store.do?datagridRead" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="name" sortOrder="asc">
	<t:dgCol title="仓库编号" field="id" hidden="false" query="true"></t:dgCol>
	<t:dgCol title="仓库名称" sortable="false" field="name" query="true"></t:dgCol>
	<t:dgCol title="仓库位置" field="position" ></t:dgCol>
	<t:dgCol title="公司名称" sortable="false" field="tsDepart.departname" query="false"></t:dgCol>
</t:datagrid>