<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div style="border:0px solid red;width:100%">
	<table style="width:100%">
		<tr>
			<td><lable>入库单号：</lable><input disabled style="background:#CCCCCC" id="storageDocNo" value="${storageDoc.storageDocNo}" type="text"></td>
			<td>
				<lable>仓库编号：</lable>
				<input name="storeId" type="text" value="${storageDoc.store.id}" disabled style="background:#CCCCCC" id="storeId" readonly="readonly" datatype="*"/> 
			</td>
			<td><lable>仓库名称：</lable><input id="storeName" value="${storageDoc.store.name}" disabled style="background:#CCCCCC" name="storeName" disabled type="text"></td>
			<td><lable>仓库位置：</lable><input id="storePosition" name="storePosition" disabled style="background:#CCCCCC" value="${storageDoc.store.position}" disabled type="text"></td>
			<td><lable>部门：</lable><input disabled style="background:#CCCCCC"  type="text" value="${sessionScope.LOCAL_CLINET_USER.currentDepart.departname}"></td>
			
		</tr>
		<tr>
			<td><lable>入库类型：</lable><input disabled style="background:#CCCCCC" id="storageDocType" value="采购入库" type="text"></td>
			<td><lable>&nbsp;&nbsp;&nbsp;&nbsp;入库人：</lable><input disabled style="background:#CCCCCC" value="${sessionScope.LOCAL_CLINET_USER.userName}" type="text"></td>
			<td><lable>&nbsp;&nbsp;&nbsp;审核人：</lable><input disabled style="background:#CCCCCC"  value="${sessionScope.LOCAL_CLINET_USER.userName}" type="text"></td>
		</tr>
	</table>
</div>
<br>
<t:datagrid name="storageDetailList" title="入库单明细记录" checkbox="true" pagination="true" actionUrl="storageDetail.do?datagrid&storageDocNo=${storageDoc.storageDocNo}" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="price" sortOrder="asc">
	<t:dgCol title="入库单明细主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="入库单号" field="storageDoc.storageDocNo"></t:dgCol>
	<t:dgCol title="设备编码" field="device.code" ></t:dgCol>
	<t:dgCol title="设备编号" field="device.deviceNum"></t:dgCol>

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