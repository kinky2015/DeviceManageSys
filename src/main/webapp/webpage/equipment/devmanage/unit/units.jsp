<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="units" title="计量单位" checkbox="true" pagination="true" actionUrl="unitController.do?datagrid" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="id" sortOrder="asc">
	<t:dgCol title="ID" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="编码" field="code" width="100"></t:dgCol>
	<t:dgCol title="计量单位" field="unit" width="150"></t:dgCol>
	<t:dgCol title="备注" field="remark" width="250"></t:dgCol>
	<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	<t:dgFunOpt funname="delUnit(id)" title="删除" urlclass="ace_button" urlStyle="background-color:#ec4758;" urlfont="fa-trash-o"></t:dgFunOpt>
	
	<t:dgToolBar title="新增" icon="icon-add" url="unitController.do?addorupdate" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="unitController.do?addorupdate" funname="update"></t:dgToolBar>
	<t:dgToolBar title="删除" icon="icon-remove" url="unitController.do?deleteBatch" funname="deleteALLSelect"></t:dgToolBar>
	<%-- <t:dgToolBar title="导出" icon="icon-putout" funname="exportXls"></t:dgToolBar> --%>
</t:datagrid>
<script>
	//删除选中计量单位
	function delUnit(id)
	{
		var tabName= 'units';
		var url= 'unitController.do?deleteSelectUnit&id='+id;
		$.dialog.confirm('你确认要删除此条记录吗？', function(){
			doSubmit(url,tabName);
		}, 
		function(){});
	}
	
	//导出Excel
	function exportXls() 
	{
		JeecgExcelExport("customerInfo.do?exportXls", "customerList");
	}
</script>