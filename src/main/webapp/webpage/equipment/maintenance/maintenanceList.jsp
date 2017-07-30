<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="maintenanceList" title="维修厂商信息" checkbox="true" pagination="true" actionUrl="maintenance.do?datagrid"  fit="true" fitColumns="true" idField="id" queryMode="group" sortName="name" sortOrder="asc">
	<t:dgCol title="ID" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="厂商编号" field="num"></t:dgCol>
	<t:dgCol title="厂商名称" sortable="false" field="name" query="true"></t:dgCol>
	<t:dgCol title="联系人" field="contactor" ></t:dgCol>
	<t:dgCol title="手机号" sortable="false" field="telphone" query="false"></t:dgCol>
	<t:dgCol title="固定电话" field="phone" query="false"></t:dgCol>
	<t:dgCol title="地址" field="address"></t:dgCol>
	<t:dgCol title="备注" field="remark"></t:dgCol>
	<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	 <t:dgFunOpt funname="del(id)" title="删除" urlclass="ace_button" urlStyle="background-color:#ec4758;" urlfont="fa-trash-o"></t:dgFunOpt>
	
	<t:dgToolBar title="新增" icon="icon-add" url="maintenance.do?addOrEdit" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="maintenance.do?addOrEdit" funname="update"></t:dgToolBar>
	<t:dgToolBar title="删除" icon="icon-remove" url="maintenance.do?deleteAll" funname="deleteALLSelect"></t:dgToolBar>
	<%-- <t:dgToolBar title="导出" icon="icon-putout" funname="exportXls"></t:dgToolBar> --%>
</t:datagrid>
<script>
	//删除维修厂商
	function del(id)
	{
		var tabName= 'maintenanceList';
		var url= 'maintenance.do?delete&id='+id;
		$.dialog.confirm('你确认要删除此条记录吗？', function(){
			doSubmit(url,tabName);
		}, 
		function(){});
	}
	
	//导出Excel
	function exportXls() 
	{
		JeecgExcelExport("maintenance.do?exportXls", tabName);
	}
</script>