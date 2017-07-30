<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>盘点信息编辑</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: auto" scroll="yes">
<t:formvalid formid="formobj" dialog="true" layout="table" action="stockCheck.do?saveStockCheck">
	<input id="id" name="id" type="hidden" value="${result.id }">
	<input id="deviceInv.id" name="deviceInv.id" type="hidden" value="${result.deviceInv.id }">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 盘点编号:  </label>
            </td>
			<td class="value" width="85%">
                <input id="stockCheckNo" class="inputxt" readOnly style="background:#CCCCCC" name="stockCheckNo" value="${result.stockCheckNo }"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 仓库编号: </label></td>
			<td class="value" width="10%">
                <input id="deviceInv.store.id" class="inputxt" readOnly style="background:#CCCCCC" name="deviceInv.store.id" value="${result.deviceInv.store.id }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 仓库名称: </label></td>
			<td class="value" width="10%">
                <input id="deviceInv.store.name" class="inputxt" readOnly style="background:#CCCCCC" name="deviceInv.store.name" value="${result.deviceInv.store.name }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 设备编号: </label></td>
			<td class="value" width="10%">
                <input id="deviceInv.device.code" class="inputxt" readOnly style="background:#CCCCCC" name="deviceInv.device.code" value="${result.deviceInv.device.code }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 设备名称: </label></td>
			<td class="value" width="10%">
                <input id="deviceInv.device.name" class="inputxt" readOnly style="background:#CCCCCC" name="deviceInv.device.name" value="${result.deviceInv.device.name }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr style="display:none">
			<td align="right" width="10%" nowrap><label class="Validform_label"> 设备价格: </label></td>
			<td class="value" width="10%">
                <input id="deviceInv.price" class="inputxt" readOnly style="background:#CCCCCC" name="deviceInv.price" value="${result.deviceInv.price }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 设备库存量: </label></td>
			<td class="value" width="10%">
                <input id="deviceInv.count" class="inputxt" readOnly style="background:#CCCCCC" name="deviceInv.count" value="${result.deviceInv.count }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr style="display:none">
			<td align="right" width="10%" nowrap><label class="Validform_label"> 设备总价格: </label></td>
			<td class="value" width="10%">
                <input id="deviceInv.sumPrice" class="inputxt" readOnly style="background:#CCCCCC" name="deviceInv.sumPrice" value="${result.deviceInv.sumPrice }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 供应商编号: </label></td>
			<td class="value" width="10%">
                <input id="deviceInv.supplier.supplierNo" readOnly style="background:#CCCCCC" class="inputxt" name="deviceInv.supplier.supplierNo" value="${result.deviceInv.supplier.supplierNo }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 供应商名称: </label></td>
			<td class="value" width="10%">
                <input id="deviceInv.supplier.supplierName" readOnly style="background:#CCCCCC" class="inputxt" name="deviceInv.supplier.supplierName" value="${result.deviceInv.supplier.supplierName }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 期初库存: </label></td>
			<td class="value" width="10%">
                <input id="openInvCount" class="inputxt" readOnly style="background:#CCCCCC" name="openInvCount" value="${result.openInvCount }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 期末库存: </label></td>
			<td class="value" width="10%">
                <input id="closeInvCount" class="inputxt"  name="closeInvCount" onblur="changeEvt();" value="${result.closeInvCount }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 亏损数量: </label></td>
			<td class="value" width="10%">
                <input id="lossCount" class="inputxt" readOnly style="background:#CCCCCC" name="lossCount" value="${result.lossCount }">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr style="display:none">
			<td align="right" width="10%" nowrap><label class="Validform_label"> 亏损金额: </label></td>
			<td class="value" width="10%">
                <input id="lossPrice" class="inputxt" readOnly style="background:#CCCCCC" name="lossPrice" value="${result.lossPrice}">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 盈余数量: </label></td>
			<td class="value" width="10%">
                <input id="profitCount" class="inputxt" readOnly style="background:#CCCCCC" name="profitCount" value="${result.profitCount}">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr style="display:none">
			<td align="right" width="10%" nowrap><label class="Validform_label"> 盈余金额: </label></td>
			<td class="value" width="10%">
                <input id="profitPrice" class="inputxt" readOnly style="background:#CCCCCC" name="profitPrice" value="${result.profitPrice}">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
	</table>
</t:formvalid>
</body>
<script>
	function changeEvt()
	{
		//获取设备库存量
		var count = $("input[name='deviceInv.count']").val();
		
		//获取期末库存
		var closeInvCount = $("input[name='closeInvCount']").val();
		
		//设备金额
		var price = parseFloat($("input[name='deviceInv.price']").val());
		
		console.log(count + "|" + closeInvCount + "|" + price);
		
		if(count == closeInvCount) //正常
		{
			$("input[name='lossCount']").val(0);
			$("input[name='lossPrice']").val(0);
			$("input[name='profitCount']").val(0);
			$("input[name='profitPrice']").val(0);
		}
		else if(count > closeInvCount) //亏损
		{
			$("input[name='lossCount']").val(parseInt(count) - parseInt(closeInvCount));
			$("input[name='lossPrice']").val((parseInt(count) - parseInt(closeInvCount)) * price);
			$("input[name='profitCount']").val(0);
			$("input[name='profitPrice']").val(0);
		}
		else if(count < closeInvCount) //盈利
		{
			$("input[name='lossCount']").val(0);
			$("input[name='lossPrice']").val(0);
			$("input[name='profitCount']").val(parseInt(closeInvCount) - parseInt(count));
			$("input[name='profitPrice']").val((parseInt(closeInvCount) - parseInt(count)) * price);
		}
	}
</script>