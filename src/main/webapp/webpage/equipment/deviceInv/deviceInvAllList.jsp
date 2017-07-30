<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String basePath=request.getContextPath();
	request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择供应商设备</title>
	<script type="text/javascript">
		function checkCount(obj)
		{
			var count = parseInt(obj.value);
			var sum = parseInt(obj.getAttribute("sum"));
			var price = parseFloat(obj.getAttribute("price"));
			var devInvId = obj.getAttribute("devInvId");
			if(count > sum)
			{
				alert("不能大于剩余数量")
			}
			console.log(devInvId);
			document.getElementById(devInvId).value = count*price;
		}
	</script>
	<link rel="stylesheet" type="text/css" href="${basePath}/webpage/equipment/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" type="text/css" href="${basePath}/webpage/equipment/css/bootstrap.min.css" />
</head>
<body>
<form id="devInvForm">
	<table class="table table-striped">
		<caption>设备库存</caption>
		<thead>
			<tr>
				<th>供应商编号</th>
				<th>供应商名称</th>
				<th>设备编码</th>
				<th>设备编号</th>
				<th>设备名称</th>
				<th style="display:none">单价</th>
				<th>剩余数量</th>
				<th>出库数量</th>
				<th style="display:none">总金额</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.results}" var="result">
				<tr>
					<td>${result.supplier.supplierNo}</td>
					<td>${result.supplier.supplierName}</td>
					<td>${result.device.code}</td>
					<td>${result.device.deviceNum}</td>
					<td>${result.device.name}</td>
					<td style="display:none">${result.price}</td>
					<td>${result.count}</td>
					<td><input type="text" value="" supplierNo="${result.supplier.supplierNo}" id="" devInvId="${result.id}" price="${result.price}" sum="${result.count}" onblur="checkCount(this)" name="count" style="width:50px"></td>
					<td style="display:none"><input type="text" value="" id="${result.id}" disabled name="sumPrice" style="width:50px"></td>
				</tr>
			</c:forEach>
		<tbody>
	</table>
</form>
</body>
</html>