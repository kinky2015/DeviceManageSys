<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="stockCheckList" title="库存信息" checkbox="true" pagination="true" actionUrl="stockCheck.do?datagrid" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="stockCheckNo" sortOrder="asc">
	<t:dgCol title="盘点库存主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="盘库编码" field="stockCheckNo" hidden="true" query="true"></t:dgCol>
	<t:dgCol title="设备编码" field="deviceInv.device.code" query="true"></t:dgCol>
	<t:dgCol title="设备编号" field="deviceInv.device.deviceNum" query="true"></t:dgCol>
	<t:dgCol title="设备名称" field="deviceInv.device.name" query="true"></t:dgCol>
	<t:dgCol title="仓库编号" field="deviceInv.store.id" query="true"></t:dgCol>
	<t:dgCol title="仓库名称" field="deviceInv.store.name" query="true"></t:dgCol>
	<t:dgCol title="仓库位置" field="deviceInv.store.position" query="true"></t:dgCol>
	<t:dgCol title="设备规格" field="deviceInv.device.deviceSpec"></t:dgCol>
	<t:dgCol title="单位" field="deviceInv.device.units.unit"></t:dgCol>
	<t:dgCol title="库存数量" field="deviceInv.count"></t:dgCol>
	<t:dgCol title="供应商编号" field="deviceInv.supplier.supplierNo"></t:dgCol>
	<t:dgCol title="供应商名称" field="deviceInv.supplier.supplierName"></t:dgCol>
	<t:dgCol title="期初库存" field="openInvCount"></t:dgCol>
	<t:dgCol title="期末库存" field="closeInvCount"></t:dgCol>
	<t:dgCol title="盈余数量" field="profitCount"></t:dgCol>
	<t:dgCol title="亏损数量" field="lossCount"></t:dgCol>
	
	<t:dgToolBar title="新增盘点记录" icon="icon-add" funname="createNewInfo"></t:dgToolBar>
	<t:dgToolBar title="编辑盘点记录" icon="icon-edit" url="stockCheck.do?stockModify" funname="update"></t:dgToolBar>
	<t:dgToolBar title="删除盘点记录" icon="icon-remove" url="stockCheck.do?deleteBatch" funname="deleteALLSelect"></t:dgToolBar>
	<t:dgToolBar title="导出" icon="icon-putout" funname="exportXls"></t:dgToolBar>
</t:datagrid>
<script>
	function createNewInfo()
	{
		var width = window.top.document.body.offsetWidth;
		var height =window.top.document.body.offsetHeight-100;
		var url="stockCheck.do?addorupdate";
		$.dialog({
			content: 'url:'+url,
			lock : true,
			zIndex: getzIndex(),
			width:width,
			height:height,
			title:"新增盘点信息",
			opacity : 0.3,
			cache:false,
		    ok: function()
		    {
		    	$("#stockCheckList").datagrid("reload");
		    	return true;
		    }
		});
	}
</script>