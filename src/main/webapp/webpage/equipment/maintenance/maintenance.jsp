<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>生产厂商</title>
<t:base type="jquery,easyui,tools"></t:base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<t:formvalid formid="maintenanceForm" dialog="true" layout="table" action="maintenance.do?saveOrUpdate">
		<input type="hidden" id="id" name="id" value="${maintenance.id}"/>
		<input type="hidden" id="num" name="num" value="${maintenance.num}"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right" width="25%" nowrap>
	                <label class="Validform_label">  厂商名称:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="name" class="inputxt" name="name" value="${maintenance.name }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	        </tr>
	         
	        <tr>   
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  联系人:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="contactor" class="inputxt" name="contactor" value="${maintenance.contactor }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	       </tr> 
	          
	       <tr>  
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  手机号码:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="telphone" class="inputxt" name="telphone" value="${maintenance.telphone }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	       </tr>     
	          
	       <tr>    
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  厂商电话:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="phone" class="inputxt" name="phone" value="${maintenance.phone }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	        </tr> 
	         
	       <tr>   
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  地址:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="address" class="inputxt" name="address" value="${maintenance.address }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	       </tr>  
	       <tr>
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  备注:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="remark" class="inputxt" name="remark" value="${supplier.remark }"/>
	                <span class="Validform_checktip"></span>
	            </td>
			</tr>
		</table>
	</t:formvalid>
</body>
</html>