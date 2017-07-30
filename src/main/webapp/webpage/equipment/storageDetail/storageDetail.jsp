<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>仓库信息管理</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
	$(function(){
		var data = $("#data").text();
		if(data != "")
		{
			var detail = JSON.parse(data); 
			setFormJonsData($("#formobj"), detail);	
		}
		
		$('#categoryTree').combotree({
			url : 'categoryController.do?combotree',
			panelHeight : 200,
			width : 157,
			onClick : function(node) {
				$("#categoryTree").val(node.name);
				$("#tsCategoryId").val(node.id);
			}
		});
	});
	
	function setFormJonsData(form, data)
	{
		$.each(data, function (name, val) {
			form.find("input[name='" + name + "']").val(val);
		});
	}
</script>
</head>
<body scroll="yes">
<t:formvalid formid="formobj" dialog="true" layout="table" action="storageDetail.do?saveStorageDetail">
	<div id="data" style="display:none">${data}</div>
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 设备编码:  </label>
            </td>
			<td class="value" width="85%">
                <input readonly class="inputxt" name="device.code" value="${deviceCode}"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 设备编号:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.deviceNum"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 设备名称:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.name"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 设备规格:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.deviceSpec"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr><tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 设备类别:  </label>
            </td>
			<td class="value" width="85%">
                <input id="tsCategoryId" name="device.tsCategory.id" type="hidden">
				<input id="categoryTree" name="device.tsCategory.name">
                <span class="Validform_checktip"></span>
            </td>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 资产编号:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.assetNum"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr><tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 单位:  </label>
            </td>
			<td class="value" width="85%">
                <t:dictSelect field="device.units.unit" defaultVal="${device.units.id}" dictTable="e_units" dictField="id" dictText="unit" title="单位"></t:dictSelect>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 价格:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.unitPrice" />
                <span class="Validform_checktip"></span>
            </td>
		</tr><tr>
            <td align="right" width="25%"  nowrap>
                <label class="Validform_label"> 生产商名称:  </label>
            </td>
			<td class="value"  width="85%">
                <t:dictSelect field="device.manufacturer.id" defaultVal="${device.manufacturer.id}" dictTable="tbl_manufacturer" dictField="id" dictText="name" title="生产商"></t:dictSelect>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 供应商名称:  </label>
            </td>
			<td class="value" width="85%">
                <t:dictSelect field="device.supplier.supplierNo" defaultVal="${device.supplier.supplierNo}" dictTable="tbl_supplier" dictField="supplierNo" dictText="supplierName" title="供应商"></t:dictSelect>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 维修厂商名称:  </label>
            </td>
			<td class="value" width="85%">
                <t:dictSelect field="device.maintenance.id" defaultVal="${device.maintenance.id}" dictTable="tbl_maintenance" dictField="id" dictText="name" title="生产商"></t:dictSelect>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 合同名称:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.contractName"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 合同编号:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.contractNum"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 技术参数:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.technicalParam"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr><tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 实物管理部门:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.objDepart"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 实物管理部门责任人:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.zrUser"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr><tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 使用保管部门:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.useDepart"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 使用保管部门责任人:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.useUser" />
                <span class="Validform_checktip"></span>
            </td>
		</tr><tr>
            <td align="right" width="25%"  nowrap>
                <label class="Validform_label"> 验收人:  </label>
            </td>
			<td class="value"  width="85%">
                <input class="inputxt" name="device.ysUser"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 资产增加方式:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.zczjfs"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 启用日期:  </label>
            </td>
			<td class="value" width="85%">
                <input id="birthday" name="device.qyDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 资产使用情况:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.tStype.typename"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 出产日期:  </label>
            </td>
			<td class="value" width="85%">
                <input id="birthday" name="device.ccDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 购买日期:  </label>
            </td>
			<td class="value" width="85%">
                <input id="birthday" name="device.buyDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr><tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 出产厂商编号:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.outNum"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 资金源头:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.capital"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr><tr>
            <td align="right" width="25%"  nowrap>
                <label class="Validform_label"> 数量:  </label>
            </td>
			<td class="value"  width="85%">
                <input class="inputxt" name="count" value="1"/>
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 价格:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="sumPrice"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
            <td align="right" width="25%"  nowrap>
                <label class="Validform_label"> 备注:  </label>
            </td>
			<td class="value"  width="85%">
                <input class="inputxt" name="remark" />
                <span class="Validform_checktip"></span>
            </td>
            <td align="right" width="25%" nowrap>
                <label class="Validform_label"> 附属设备编号:  </label>
            </td>
			<td class="value" width="85%">
                <input class="inputxt" name="device.parentDevice.deviceNum"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
	</table>
</t:formvalid>
<script>
	/*function selectDevice()
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
		    ok: function(){
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
		    	
		    	
		    },
		    cancelVal: '关闭',
		    cancel: true 
		});
	}*/
	
	/*function totalPrice()
	{
		var count = parseInt($("input[name='count']").val());
		var price = parseFloat($("input[name='price']").val());
		var total = count*price;
		$("input[name='sumPrice']").val(total)
	}*/
	
	/*function selectSupplier()
	{
		var url="supplier.do?supplierRead";
		$.dialog({
			content: 'url:'+url,
			lock : true,
			zIndex: getzIndex(),
			width:900,
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
		    cancel: true
		});
	}*/
</script>
</body>