<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="storeList" title="仓库信息管理" checkbox="true" pagination="true" actionUrl="store.do?datagrid" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="name" sortOrder="asc">
	<t:dgCol title="仓库编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="仓库名称" sortable="false" field="name" query="true"></t:dgCol>
	<t:dgCol title="仓库位置" field="position" ></t:dgCol>
	<t:dgCol title="公司名称" sortable="false" field="tsDepart.departname" query="false"></t:dgCol>
	<t:dgCol title="common.operation" field="opt" width="100"></t:dgCol>
	<t:dgFunOpt funname="delStore(id)" title="删除仓库" urlclass="ace_button" urlStyle="background-color:#ec4758;" urlfont="fa-trash-o"></t:dgFunOpt>
	
	<t:dgToolBar title="新增仓库" icon="icon-add" url="store.do?addorupdate" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑仓库" icon="icon-edit" url="store.do?addorupdate" funname="update"></t:dgToolBar>
	<t:dgToolBar title="删除仓库" icon="icon-remove" url="store.do?deleteBatch" funname="deleteALLSelect"></t:dgToolBar>
	<t:dgToolBar title="导出" icon="icon-putout" funname="exportXls"></t:dgToolBar>
</t:datagrid>
<script>
	//删除客户资料信息
	function delStore(id)
	{
		var tabName= 'storeList';
		var url= 'store.do?deleteStore&id='+id;
		$.dialog.confirm('你确认要删除此条记录吗？', function(){
			doSubmit(url,tabName);
		}, 
		function(){});
	}
	
	//导出Excel
	function exportXls() 
	{
		JeecgExcelExport("store.do?exportXls", "storeList");
	}
</script>