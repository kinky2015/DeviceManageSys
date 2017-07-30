<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="supplierList" title="供应商资料" checkbox="true" pagination="true" actionUrl="supplier.do?datagrid" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="supplierName" sortOrder="asc">
	<t:dgCol title="供应商编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="供应商编号" field="supplierNo"></t:dgCol>
	<t:dgCol title="供应商名称" sortable="false" field="supplierName" query="true"></t:dgCol>
	<t:dgCol title="联系人" field="contactor" ></t:dgCol>
	<t:dgCol title="供应商手机号" sortable="false" field="telphone" query="false"></t:dgCol>
	<t:dgCol title="供应商固定电话" field="phone" query="false"></t:dgCol>
	<t:dgCol title="税号" field="dutyNo"></t:dgCol>
	<t:dgCol title="开户行地址" field="cardAddress"></t:dgCol>
	<t:dgCol title="卡号" field="cardNo"></t:dgCol>
	<t:dgCol title="产品简介" field="productDesc"></t:dgCol>
	<t:dgCol title="备注" field="remark"></t:dgCol>
	<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	<t:dgFunOpt funname="delSupplier(id)" title="删除供应商" urlclass="ace_button" urlStyle="background-color:#ec4758;" urlfont="fa-trash-o"></t:dgFunOpt>
	
	<t:dgToolBar title="新增供应商" icon="icon-add" url="supplier.do?addorupdate" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑供应商" icon="icon-edit" url="supplier.do?addorupdate" funname="update"></t:dgToolBar>
	<t:dgToolBar title="删除供应商" icon="icon-remove" url="supplier.do?deleteBatch" funname="deleteALLSelect"></t:dgToolBar>
	<t:dgToolBar title="导出" icon="icon-putout" funname="exportXls"></t:dgToolBar>
</t:datagrid>
<script>
	//删除客户资料信息
	function delSupplier(id)
	{
		var tabName= 'supplierList';
		var url= 'supplier.do?deleteSupplier&id='+id;
		$.dialog.confirm('你确认要删除此条记录吗？', function(){
			doSubmit(url,tabName);
		}, 
		function(){});
	}
	
	//导出Excel
	function exportXls() 
	{
		JeecgExcelExport("supplier.do?exportXls", "supplierList");
	}
</script>