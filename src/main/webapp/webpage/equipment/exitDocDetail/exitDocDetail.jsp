<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>出库新增</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body scroll="yes">
<t:formvalid formid="formobj" dialog="true" layout="table">
	<!-- 入库单信息 -->
	<input id="storeId" name="storeId" type="hidden" value="${storeId}">
	<input id="exitDocNo" name="exitDocNo" type="hidden" value="${exitDocNo}">
	<input id="exitDocType" name="exitDocType" type="hidden" value="${exitDocType}">

	<!-- 设备主键 -->
	<input id="device.id" name="device.id" type="hidden" value="${exitDetail.device.id}">
	
	<!-- 部门信息 -->
	<input id="deptId" name="tsDepart.id" type="hidden" value="${exitDetail.tsDepart.id }"/>
	
	<!-- 申请人信息 -->
	<input id="userId" name="tsUser.id" type="hidden" value="${exitDetail.tsUser.id }"/>
	
	<!-- 选择的供应商设备信息 -->
	<input id="selectPrice" name="selectPrice" type="hidden" value="${exitDetail.selectPrice}">
	<input id="selectSupplier" name="selectSupplier" type="hidden" value="${exitDetail.selectSupplier}">
	<input id="selectCount" name="selectCount" type="hidden" value="${exitDetail.selectCount}">
	<input id="selectSumPrice" name="selectSumPrice" type="hidden" value="${exitDetail.selectSumPrice}">
	<input id="selectDevInv" name="selectDevInv" type="hidden" value="${exitDetail.selectDevInv}">

	<input id="id" name="id" type="hidden" value="${exitDetail.id }">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 设备编码:  </label>
            </td>
			<td class="value" width="85%">
                <input id="device.code" readOnly class="inputxt" onclick="selectDevice()" name="device.code" value="${exitDetail.device.code}"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 设备编号:  </label>
            </td>
			<td class="value" width="85%">
                <input id="device.deviceNum" disabled style="background:#CCCCCC" class="inputxt" name="device.deviceNum" value="${exitDetail.device.deviceNum }"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 设备名称:  </label>
            </td>
			<td class="value" width="85%">
                <input id="device.name" disabled style="background:#CCCCCC" class="inputxt" name="device.name" value="${exitDetail.device.name}"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 设备规格:  </label>
            </td>
			<td class="value" width="85%">
                <input id="device.deviceSpec" disabled style="background:#CCCCCC" class="inputxt" name="device.deviceSpec" value="${exitDetail.device.deviceSpec }"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr><tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 单位:  </label>
            </td>
			<td class="value" width="85%">
                <input id="device.units.unit" disabled style="background:#CCCCCC" class="inputxt" name="device.units.unit" value="${exitDetail.device.units.unit}"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 设备类别:  </label>
            </td>
			<td class="value" width="85%">
                <input id="device.tsCategory.name" disabled style="background:#CCCCCC" class="inputxt" name="device.tsCategory.name" value="${exitDetail.device.tsCategory.name}"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr><tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 适用设备:  </label>
            </td>
			<td class="value" width="85%">
                <input id="device.suitDivce.name" disabled style="background:#CCCCCC" class="inputxt" name="device.suitDivce.name" value="${exitDetail.device.suitDivce.name}"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 高库存指标:  </label>
            </td>
			<td class="value" width="85%">
                <input id="device.hightItem" disabled style="background:#CCCCCC" class="inputxt" name="device.hightItem" value="${exitDetail.device.hightItem }"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr><tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 低库存指标:  </label>
            </td>
			<td class="value" width="85%">
                <input id="device.lowItem" disabled style="background:#CCCCCC" class="inputxt" name="device.lowItem" value="${exitDetail.device.lowItem }"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" style="display:none" nowrap>
                <label class="Validform_label"> 参考价格:  </label>
            </td>
			<td class="value" width="85%" style="display:none">
                <input id="device.refPrice" disabled style="background:#CCCCCC" class="inputxt" name="device.refPrice" value="${exitDetail.device.refPrice }"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr><tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 数量:  </label>
            </td>
			<td class="value" width="85%">
                <input id="count" class="inputxt" name="count" value="${exitDetail.count }"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap style="display:none">
                <label class="Validform_label"> 出库总价格:  </label>
            </td>
			<td class="value" width="85%" style="display:none">
                <input id="sumPrice" class="inputxt" name="sumPrice" value="${exitDetail.sumPrice}"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 申请人:  </label>
            </td>
			<td class="value" width="85%">
                <input id="tsUser.userName" readonly onclick="selectUser();" class="inputxt" name="tsUser.userName" value="${exitDetail.tsUser.userName}"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 申请部门:  </label>
            </td>
			<td class="value" width="85%">
                <input id="tsDepart.departname" disabled style="background:#CCCCCC" class="inputxt" name="tsDepart.departname" value="${exitDetail.tsDepart.departname }"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 申请原因:  </label>
            </td>
			<td class="value" width="85%">
                <input id="reason" class="inputxt" name="reason" value="${exitDetail.reason}"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 备注:  </label>
            </td>
			<td class="value" width="85%">
                <input id="remark" class="inputxt" name="remark" value="${exitDetail.remark }"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
	</table>
</t:formvalid>
<script>
	function selectDevice()
	{
		var url="device.do?deviceRead";
		$.dialog({
			content: 'url:'+url,
			lock : true,
			zIndex: getzIndex(),
			width:900,
			height:480,
			title:"设备信息",
			opacity : 0.3,
			cache:false,
		    ok: function()
		    {
		    	var iframe = this.iframe.contentWindow;
		    	var id = iframe.getdeviceListSelections("id")[0];
		    	var code = iframe.getdeviceListSelections("code")[0];
		    	var deviceNum = iframe.getdeviceListSelections("deviceNum")[0];
		    	var name = iframe.getdeviceListSelections("name")[0];
		    	var deviceSpec = iframe.getdeviceListSelections("deviceSpec")[0];
		    	var unitName = iframe.getdeviceListSelections("units.unit")[0];
		    	var tsCategoryName = iframe.getdeviceListSelections("tsCategory.name")[0];
		    	var suitDivceName = iframe.getdeviceListSelections("suitDivce.name")[0];
		    	var hightItem = iframe.getdeviceListSelections("hightItem")[0];
		    	var lowItem = iframe.getdeviceListSelections("lowItem")[0];
		    	var refPrice = iframe.getdeviceListSelections("refPrice")[0];
		    	
		    	$("input[name='device.id']").val(id);
		    	$("input[name='device.code']").val(code);
		    	$("input[name='device.deviceNum']").val(deviceNum);
		    	$("input[name='device.name']").val(name);
		    	$("input[name='device.deviceSpec']").val(deviceSpec);
		    	$("input[name='device.units.unit']").val(unitName);
		    	$("input[name='device.tsCategory.name']").val(tsCategoryName);
		    	$("input[name='device.suitDivce.name']").val(suitDivceName);
		    	$("input[name='device.hightItem']").val(hightItem);
		    	$("input[name='device.lowItem']").val(lowItem);
		    	$("input[name='device.refPrice']").val(refPrice);
		    	
		    	//获取设备库存信息
		    	getDeviceStorage();
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
	}
	
	function getDeviceStorage()
	{
		var url="deviceInv.do?getListPage";
		$.dialog({
			content: 'url:'+url,
			lock : true,
			zIndex: getzIndex(),
			width:900,
			height:480,
			title:"设备信息",
			opacity : 0.3,
			cache:false,
		    ok: function()
		    {
		    	var iframe = this.iframe.contentWindow;
		    	var counts = $('#devInvForm input[name="count"]', iframe.document);
		    	var sumPrices = $('#devInvForm input[name="sumPrice"]', iframe.document);
		    	var total= 0;
		    	var totalPrice=0;
		    	var supplierStr="";
		    	var priceStr="";
		    	var countStr="";
		    	var sumPriceStr="";
		    	var devInvStr="";
		    	for(var i = 0; i < counts.length; i++)
		    	{
		    		var supplier = counts[i].getAttribute("supplierNo");
		    		var price = counts[i].getAttribute("price");
		    		var count = parseInt(counts[i].value);
		    		var sumPrice = parseFloat(sumPrices[i].value);
		    		var devInvId = counts[i].getAttribute("devInvId");
		    		total = total + count;
		    		totalPrice = totalPrice + sumPrice;
		    		
		    		supplierStr = supplierStr + supplier + ",";
		    		priceStr = priceStr + price + ",";
		    		countStr = countStr + count+ ",";
		    		sumPriceStr = sumPriceStr + sumPrice + ",";
		    		devInvStr = devInvStr + devInvId + ",";
		    	}
		    	$("#sumPrice").val(totalPrice);
		    	$("#count").val(total);
		    	$("#selectSupplier").val(supplierStr);
		    	$("#selectPrice").val(priceStr);
		    	$("#selectCount").val(countStr);
		    	$("#selectSumPrice").val(sumPriceStr);
		    	$("#selectDevInv").val(devInvStr);
		    	return true;
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
	}
	
	function totalPrice()
	{
		
	}
	
	function selectSupplier()
	{
		var url="supplier.do?supplierRead";
		$.dialog({
			content: 'url:'+url,
			lock : true,
			zIndex: getzIndex(),
			width:1000,
			height:480,
			title:"供应商信息",
			opacity : 0.3,
			cache:false,
		    ok: function(){
		    	var iframe = this.iframe.contentWindow;
		    	var supplierNo = iframe.getsupplierListSelections("supplierNo")[0];
		    	var supplierName = iframe.getsupplierListSelections("supplierName")[0];
		    	
		    	$("input[name='supplier.supplierNo']").val(supplierNo);
		    	$("input[name='supplier.supplierName']").val(supplierName);
		    	
		    	
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
	}
	
	function selectUser()
	{
		var url="userController.do?userSelect";
		$.dialog({
			content: 'url:'+url,
			lock : true,
			zIndex: getzIndex(),
			width:900,
			height:480,
			title:"用户信息",
			opacity : 0.3,
			cache:false,
		    ok: function()
		    {
		    	var iframe = this.iframe.contentWindow;
		    	var userId = iframe.getuserList1Selections("id")[0];
		    	var userName = iframe.getuserList1Selections("userName")[0];
		    	var depId = iframe.getuserList1Selections("userOrgList.tsDepart.id")[0];
		    	var depName = iframe.getuserList1Selections("userOrgList.tsDepart.departname")[0];
		    	$("#userId").val(userId);
		    	$("input[name='tsUser.userName']").val(userName);
		    	$("#deptId").val(depId.replace(",", ""));
		    	$("input[name='tsDepart.departname']").val(depName.replace(",", ""));
		    	return true;
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
	}
</script>
</body>