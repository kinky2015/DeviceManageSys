<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="customerList" title="客户资料" checkbox="true" pagination="true" actionUrl="customerInfo.do?datagrid" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="customerName" sortOrder="asc">
	<t:dgCol title="客户编码" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="客户编码" field="customerNo"></t:dgCol>
	<t:dgCol title="客户名称" sortable="false" field="customerName" query="true"></t:dgCol>
	<t:dgCol title="客户固定电话" field="phone" query="false"></t:dgCol>
	<t:dgCol title="客户手机号" sortable="false" field="telphone" query="false"></t:dgCol>
	<t:dgCol title="联系人" field="contactor" ></t:dgCol>
	<t:dgCol title="客户意向产品" field="product"></t:dgCol>
	<t:dgCol title="客户地址" field="address"></t:dgCol>
	<t:dgCol title="附件" field="options"></t:dgCol>
	<t:dgCol title="备注" field="remark"></t:dgCol>
	<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	<t:dgFunOpt funname="delCustomer(id)" title="删除客户" urlclass="ace_button" urlStyle="background-color:#ec4758;" urlfont="fa-trash-o"></t:dgFunOpt>
	
	<t:dgToolBar title="新增客户" icon="icon-add" url="customerInfo.do?addorupdate" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑客户" icon="icon-edit" url="customerInfo.do?addorupdate" funname="update"></t:dgToolBar>
	<t:dgToolBar title="删除客户" icon="icon-remove" url="customerInfo.do?deleteBatch" funname="deleteALLSelect"></t:dgToolBar>
	<t:dgToolBar title="导出" icon="icon-putout" funname="exportXls"></t:dgToolBar>
</t:datagrid>
<script>
	//删除客户资料信息
	function delCustomer(id)
	{
		var tabName= 'customerList';
		var url= 'customerInfo.do?deleteCustomer&id='+id;
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