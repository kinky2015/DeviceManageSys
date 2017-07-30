<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户信息</title>
<t:base type="jquery,easyui,tools"></t:base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<t:formvalid formid="supplierForm" dialog="true" layout="table" action="supplier.do?saveSupplier">
		<input type="hidden" id="supplierNo" name="supplierNo" value="${supplier.supplierNo}"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right" width="25%" nowrap>
	                <label class="Validform_label">  供应商名称:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="supplierName" class="inputxt" name="supplierName" value="${supplier.supplierName }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	        </tr>
	         
	        <tr>   
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  联系人:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="contactor" class="inputxt" name="contactor" value="${supplier.contactor }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	       </tr> 
	          
	       <tr>  
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  手机号码:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="telphone" class="inputxt" name="telphone" value="${supplier.telphone }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	       </tr>     
	          
	       <tr>    
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  供应商电话:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="phone" class="inputxt" name="phone" value="${supplier.phone }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	        </tr> 
	         
	       <tr>   
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  税号:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="dutyNo" class="inputxt" name="dutyNo" value="${supplier.dutyNo }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	       </tr>  
	            
	       <tr>  
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  开户行地址:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="cardAddress" class="inputxt" name="cardAddress" value="${supplier.cardAddress }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	       </tr> 
	            
	       <tr>
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  卡号:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="cardNo" class="inputxt" name="cardNo" value="${supplier.cardNo }"/>
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