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
	<t:formvalid formid="customerForm" dialog="true" layout="table" action="customerInfo.do?saveCustomer">
		<input type="hidden" id="customerNo" name="customerNo" value="${customer.customerNo}"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right" width="25%" nowrap>
	                <label class="Validform_label">  客户名称:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="customerName" class="inputxt" name="customerName" value="${customer.customerName }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	        </tr>
	          
	       <tr>    
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  客户电话:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="phone" class="inputxt" name="phone" value="${customer.phone }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	        </tr> 
	         
	       <tr>  
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  手机号码:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="telphone" class="inputxt" name="telphone" value="${customer.telphone }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	       </tr>  
	         
	       <tr>   
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  联系人:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="contactor" class="inputxt" name="contactor" value="${customer.contactor }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	       </tr>
	         
	       <tr>   
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  意向产品:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="product" class="inputxt" name="product" value="${customer.product }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	       </tr>  
	            
	       <tr>  
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  联系地址:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="address" class="inputxt" name="address" value="${customer.address }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	       </tr> 
	            
	       <tr>
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  附件:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="options" class="inputxt" name="options" value="${customer.options }"/>
	                <span class="Validform_checktip"></span>
	            </td>
	       </tr>
	          
	       <tr>
	            <td align="right" width="25%" nowrap>
	                <label class="Validform_label">  备注:  </label>
	            </td>
				<td class="value" width="85%">
	                <input id="remark" class="inputxt" name="remark" value="${customer.remark }"/>
	                <span class="Validform_checktip"></span>
	            </td>
			</tr>
		</table>
	</t:formvalid>
</body>
</html>