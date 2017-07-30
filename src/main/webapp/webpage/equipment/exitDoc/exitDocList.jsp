<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div style="border:0px solid red;width:100%">
	<table style="width:100%">
		<tr>
			<td><lable>出库单号：</lable><input disabled style="background:#CCCCCC" id="exitDocNo" value="${exitDocNo}" type="text"></td>
			<td><lable>仓库名称：</lable><input id="storeName" name="storeName" disabled type="text"></td>
			<%-- <td><lable>&nbsp;&nbsp;&nbsp;入库人：</lable><input disabled style="background:#CCCCCC"  value="${sessionScope.LOCAL_CLINET_USER.userName}" type="text"></td> --%>
			<td><lable>&nbsp;&nbsp;&nbsp;入库人：</lable><input class="easyui-combotree" data-options="url:'webpage/equipment/exitDoc/tree_data1.json',method:'get',required:true" style="width:200px;">
		</tr>
	</table>
</div>
<br>
<t:datagrid name="exitDetailList" title="出库单明细记录" checkbox="true" pagination="true" actionUrl="exitDoc.do?datagrid" fit="true" fitColumns="true" idField="id" queryMode="group"  sortOrder="asc">
	<t:dgCol title="ID" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="设备编码" field="device.code" ></t:dgCol>
	<t:dgCol title="设备编号" field="device.deviceNum"></t:dgCol>
	<t:dgCol title="设备名称" field="device.name"></t:dgCol>
	<t:dgCol title="设备规格" field="device.deviceSpec"></t:dgCol>
	<t:dgCol title="设备类别" field="device.tsCategory.name"></t:dgCol>
	<t:dgCol title="资产编号" field="device.assetNum"></t:dgCol>
	<t:dgCol title="单位" field="device.units.unit"></t:dgCol>
	<t:dgCol title="价格" field="device.unitPrice"></t:dgCol>
	<t:dgCol title="生产商名称" field="device.manufacturer.name"></t:dgCol>
	<t:dgCol title="供应商名称" field="device.supplier.supplierName"></t:dgCol>
	<t:dgCol title="维修厂名称" field="device.maintenance.name"></t:dgCol>
	<t:dgCol title="合同名称" field="device.contractName"></t:dgCol>
	<t:dgCol title="合同编号" field="device.contractNum"></t:dgCol>
	<t:dgCol title="技术参数" field="device.technicalParam"></t:dgCol>
	<t:dgCol title="实物管理部门" field="device.objDepart"></t:dgCol>
	<t:dgCol title="实物管理部门责任人" field="device.zrUser"></t:dgCol>
	<t:dgCol title="使用保管部门" field="device.useDepart"></t:dgCol>
	<t:dgCol title="使用保管部门责任人" field="device.useUser"></t:dgCol>
	<t:dgCol title="验收人" field="device.ysUser"></t:dgCol>
	<t:dgCol title="资产增加方式" field="device.zczjfs"></t:dgCol>
	<t:dgCol title="启用日期" field="device.qyDate"></t:dgCol>
	<t:dgCol title="资产使用状况" field="device.tStype.typename"></t:dgCol>
	<t:dgCol title="出厂日期" field="device.ccDate"></t:dgCol>
	<t:dgCol title="购买日期" field="device.buyDate"></t:dgCol>
	<t:dgCol title="出产厂商编号" field="device.outNum"></t:dgCol>
	<t:dgCol title="资金源头" field="device.capital"></t:dgCol>
	<t:dgCol title="用途分类" field="device.usetype.typename"></t:dgCol>
	<t:dgCol title="附属设备编号" field="device.parentDevice.deviceNum"></t:dgCol>
	<t:dgCol title="数量" field="count"></t:dgCol>
	<t:dgCol title="备注" field="remark"></t:dgCol>
	<t:dgCol title="操作" field="opt" width="200"></t:dgCol>
	<%-- <t:dgToolBar title="新增出库记录" icon="icon-add" url="exitDoc.do?add"></t:dgToolBar> --%>
</t:datagrid>