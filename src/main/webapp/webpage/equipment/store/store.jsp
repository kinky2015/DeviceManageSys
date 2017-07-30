<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>仓库信息管理</title>
<t:base type="jquery,easyui,tools"></t:base>
    <script>
		function openDepartmentSelect() {
			$.dialog.setting.zIndex = getzIndex(); 
			var orgIds = $("#orgIds").val();
			$.dialog({content: 'url:departController.do?departSelect&orgIds='+orgIds, zIndex: 2100, title: '组织机构列表', lock: true, width: '400px', height: '350px', opacity: 0.4, button: [
			   {name: '<t:mutiLang langKey="common.confirm"/>', callback: callbackDepartmentSelect, focus: true},
			   {name: '<t:mutiLang langKey="common.cancel"/>', callback: function (){}}
		   ]}).zindex();
		}
			
		function callbackDepartmentSelect() {
			  var iframe = this.iframe.contentWindow;
			  var treeObj = iframe.$.fn.zTree.getZTreeObj("departSelect");
			  var nodes = treeObj.getCheckedNodes(true);
			  if(nodes.length>0){
			  var ids='',names='';
			  for(i=0;i<nodes.length;i++){
			     var node = nodes[i];
			     ids += node.id;
			    names += node.name;
			 }
			 $('#departname').val(names);
			 $('#departname').blur();		
			 $('#orgIds').val(ids);		
			}
		}
		
		function callbackClean(){
			$('#departname').val('');
			 $('#orgIds').val('');	
		}
		
		function setOrgIds() {}
		$(function(){
			$("#departname").prev().hide();
		});
    </script>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="store.do?saveStore" beforeSubmit="setOrgIds">
	<input id="id" name="id" type="hidden" value="${store.id }">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 仓库名称:  </label>
            </td>
			<td class="value" width="85%">
                <input id="name" class="inputxt" name="name" value="${store.name }"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 仓库位置: </label></td>
			<td class="value" width="10%">
                <input id="position" class="inputxt" name="position" value="${store.position }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 公司名称: </label></td>
			<td class="value">
                <input id="departname" name="departname" type="text" readonly="readonly" class="inputxt" datatype="*" value="${store.tsDepart.departname}">
                <input id="orgIds" name="orgIds" type="hidden" value="${store.tsDepart.id}">
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" id="departSearch" onclick="openDepartmentSelect()">选择</a>
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" id="departRedo" onclick="callbackClean()">清空</a>
                <span class="Validform_checktip"><t:mutiLang langKey="please.muti.department"/></span>
            </td>
		</tr>
	</table>
</t:formvalid>
</body>