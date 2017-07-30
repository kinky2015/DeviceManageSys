<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div style="border:0px solid red;width:100%">
	<table style="width:100%">
		<tr>
			<td><lable>出库单号：</lable><input disabled style="background:#CCCCCC" id="exitDocNo" value="${exitDoc.exitDocNo}" type="text"></td>
			<td>
				<lable>仓库编号：</lable>
				<input name="storeId" type="text" disabled style="background:#CCCCCC" id="storeId" readonly="readonly" datatype="*" value="${exitDoc.store.id}"/> 
			</td>
			<td><lable>仓库名称：</lable><input id="storeName" value="${exitDoc.store.name}" style="background:#CCCCCC" name="storeName" disabled type="text"></td>
			<td><lable>仓库位置：</lable><input id="storePosition" value="${exitDoc.store.position}" style="background:#CCCCCC" name="storePosition" disabled type="text"></td>
			<td><lable>部门：</lable><input disabled style="background:#CCCCCC"  type="text" value="${sessionScope.LOCAL_CLINET_USER.currentDepart.departname}"></td>
			
		</tr>
		<tr>
			<td><lable>出库类型：</lable><input disabled style="background:#CCCCCC" id="exitDocType" value="领用出库" type="text"></td>
			<td><lable>&nbsp;&nbsp;&nbsp;&nbsp;出库人：</lable><input disabled style="background:#CCCCCC" value="${sessionScope.LOCAL_CLINET_USER.userName}" type="text"></td>
			<td><lable>&nbsp;&nbsp;&nbsp;审核人：</lable><input disabled style="background:#CCCCCC"  value="${sessionScope.LOCAL_CLINET_USER.userName}" type="text"></td>
		</tr>
	</table>
</div>
<br>
<t:datagrid name="exitDetailList" title="出库单明细记录" checkbox="true" pagination="true" actionUrl="exitDocDetail.do?datagrid&exitDocNo=${exitDoc.exitDocNo}" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="sumPrice" sortOrder="asc">
	<t:dgCol title="出库单明细主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="出库单号" field="exitDoc.exitDocNo"></t:dgCol>
	<t:dgCol title="设备编码" field="device.code" ></t:dgCol>
	<t:dgCol title="设备编号" field="device.deviceNum"></t:dgCol>
	<t:dgCol title="设备编号" field="device.name"></t:dgCol>
	<t:dgCol title="设备规格" field="device.deviceSpec"></t:dgCol>
	<t:dgCol title="单位" field="device.units.unit"></t:dgCol>
	<t:dgCol title="设备类别" field="device.tsCategory.name"></t:dgCol>
	<t:dgCol title="适用设备" field="device.suitDivce.name"></t:dgCol>
	<t:dgCol title="高库存指标" field="device.hightItem"></t:dgCol>
	<t:dgCol title="低库存指标" field="device.lowItem"></t:dgCol>
	<t:dgCol title="数量" field="count"></t:dgCol>
	<t:dgCol title="申请部门" field="tsDepart.departname"></t:dgCol>
	<t:dgCol title="申请人" field="tsUser.userName"></t:dgCol>
	<t:dgCol title="申请原因" field="reason"></t:dgCol>
	<t:dgCol title="备注" field="remark"></t:dgCol>
	<t:dgCol title="操作" field="opt" width="200"></t:dgCol>
	<t:dgFunOpt funname="queryDetail(id)" title="查看明细" urlclass="ace_button" urlfont="fa-search"></t:dgFunOpt>
	
	<t:dgToolBar title="导出" icon="icon-putout" funname="exportXls"></t:dgToolBar>
</t:datagrid>