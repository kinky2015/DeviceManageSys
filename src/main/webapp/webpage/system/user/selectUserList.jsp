<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="userList" title="common.operation" actionUrl="userController.do?datagrid" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="createDate,userName" sortOrder="asc,desc">
	<t:dgCol title="common.id" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="common.username" sortable="false" field="userName" query="true"></t:dgCol>
	<t:dgCol title="common.real.name" field="realName" query="false"></t:dgCol>
	<t:dgCol title="common.department" sortable="false" field="userOrgList.tsDepart.departname" query="false"></t:dgCol>
	<t:dgCol title="common.role" field="userKey" ></t:dgCol>
	<t:dgCol title="common.createby" field="createBy" hidden="true"></t:dgCol>
	<t:dgCol title="common.createtime" field="createDate" formatter="yyyy-MM-dd" hidden="false"></t:dgCol>
	<t:dgCol title="common.updateby" field="updateBy" hidden="true"></t:dgCol>
	<t:dgCol title="common.updatetime" field="updateDate" formatter="yyyy-MM-dd" hidden="true"></t:dgCol>
	<t:dgCol title="common.status" sortable="true" field="status" replace="common.active_1,common.inactive_0,super.admin_-1" ></t:dgCol>
</t:datagrid>
<script type="text/javascript">
function deleteDialog(id){
	var url = "userController.do?deleteDialog&id=" + id
	createwindow("删除模式", url, 200, 100);
}
function lockObj(title,url, id) {

	gridname=id;
	var rowsData = $('#'+id).datagrid('getSelections');
	if (!rowsData || rowsData.length==0) {
		tip('<t:mutiLang langKey="common.please.select.edit.item"/>');
		return;
	}
		url += '&id='+rowsData[0].id;

	$.dialog.confirm('<t:mutiLang langKey="common.lock.user.tips"/>', function(){
		lockuploadify(url, '&id');
	}, function(){
	});
}
function unlockObj(title,url, id) {
	gridname=id;
	var rowsData = $('#'+id).datagrid('getSelections');
	if (!rowsData || rowsData.length==0) {
		tip('<t:mutiLang langKey="common.please.select.edit.item"/>');
		return;
	}
		url += '&id='+rowsData[0].id;

	$.dialog.confirm('<t:mutiLang langKey="common.unlock.user.tips"/>', function(){
		lockuploadify(url, '&id');
	}, function(){
	});
}


function lockuploadify(url, id) {
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		url : url,// 请求的action路径
		error : function() {// 请求失败处理函数
		
		},
		success : function(data) {
			var d = $.parseJSON(data);
			if (d.success) {
			var msg = d.msg;
				tip(msg);
				reloadTable();
			}
		}
	});
}
</script>

<script type="text/javascript">
	//导入
	function ImportXls() {
		openuploadwin('Excel导入', 'userController.do?upload', "userList");
	}

	//导出
	function ExportXls() {
		JeecgExcelExport("userController.do?exportXls", "userList");
	}

	//模板下载
	function ExportXlsByT() {
		JeecgExcelExport("userController.do?exportXlsByT", "userList");
	}
</script>