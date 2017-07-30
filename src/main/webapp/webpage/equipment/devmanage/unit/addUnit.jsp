<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>计量单位</title>
<t:base type="jquery,easyui,tools"></t:base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<t:formvalid formid="unitsForm" dialog="true" layout="table" action="unitController.do?saveOrUpdate">
		<input type="hidden" id="id" name="id" value="${addUnit.id }"/>
		<input type="hidden" id="code" name="code" value="${addUnit.code }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
	       <tr>    
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  计量单位:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="unit" class="inputxt" name="unit" value="${addUnit.unit }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	        </tr>        
	       <tr>
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  备注:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="remark" class="inputxt" name="remark" value="${addUnit.remark }"/>
	                <span class="Validform_checktip"></span>
	            </td>
			</tr>
		</table>
	</t:formvalid>
</body>
</html>