<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="deviceList" title="备件信息" checkbox="true" pagination="true" actionUrl="device.do?datagrid" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="name" sortOrder="asc">
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
	<t:dgCol title="参考价格" field="refPrice" hidden="true"></t:dgCol>
	<t:dgCol title="common.operation" field="opt" width="100"></t:dgCol>
	<t:dgFunOpt funname="delDevice(id)" title="删除设备" urlclass="ace_button" urlStyle="background-color:#ec4758;" urlfont="fa-trash-o"></t:dgFunOpt>
	
	<t:dgToolBar title="新增设备" icon="icon-add" url="device.do?addorupdate" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑设备" icon="icon-edit" url="device.do?addorupdate" funname="update"></t:dgToolBar>
	<t:dgToolBar title="删除设备" icon="icon-remove" url="device.do?deleteBatch" funname="deleteALLSelect"></t:dgToolBar>
	<t:dgToolBar title="导出" icon="icon-putout" funname="exportXls"></t:dgToolBar>
</t:datagrid>
<script>
	//删除客户资料信息
	function delDevice(id)
	{
		var tabName= 'deviceList';
		var url= 'device.do?deleteDevice&id='+id;
		$.dialog.confirm('你确认要删除此条记录吗？', function(){
			doSubmit(url,tabName);
		}, 
		function(){});
	}
	
	//导出Excel
	function exportXls() 
	{
		JeecgExcelExport("device.do?exportXls", "deviceList");
	}
</script>