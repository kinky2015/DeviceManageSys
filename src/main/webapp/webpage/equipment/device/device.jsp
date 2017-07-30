<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>设备信息录入</title>
<t:base type="jquery,easyui,tools"></t:base>
<script type="text/javascript">
	$(function() {
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
</script>
</head>
<body scroll="yes">
<t:formvalid formid="formobj" dialog="true" layout="table" action="device.do?saveDevice">
	<input id="id" name="id" type="hidden" value="${device.id }">
	<input id="code" name="code" type="hidden" value="${device.code }">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 设备编号:  </label>
            </td>
			<td class="value" width="85%">
                <input id="deviceNum" class="inputxt" name="deviceNum" value="${device.deviceNum}"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>	
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 设备名称:  </label>
            </td>
			<td class="value" width="85%">
                <input id="name" class="inputxt" name="name" value="${device.name}"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 设备规格: </label></td>
			<td class="value" width="10%">
                <input id="deviceSpec" class="inputxt" name="deviceSpec" value="${device.deviceSpec}">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 单位: </label></td>
			<td class="value">
                <t:dictSelect field="units.id" defaultVal="${device.units.id}" dictTable="e_units" dictField="id" dictText="unit" title="单位"></t:dictSelect>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 设备类别: </label></td>
			<td class="value">
                <input id="tsCategoryId" name="tsCategory.id" type="hidden" value="${device.tsCategory.id}">
				<input id="categoryTree" value="${device.tsCategory.name}"> 
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 适用设备: </label></td>
			<td class="value">
                <t:dictSelect field="suitDivce.id" defaultVal="${device.suitDivce.id}" dictTable="tbl_suitDevice" dictField="id" dictText="name" title="适用设备"></t:dictSelect>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> erp名称: </label></td>
			<td class="value">
                <t:dictSelect field="erp.id" dictTable="tbl_erp" defaultVal="${device.erp.id}" dictField="id" dictText="name" title="erp名称"></t:dictSelect>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 高库存指标:  </label>
            </td>
			<td class="value" width="85%">
                <input id="hightItem" class="inputxt" name="hightItem" value="${device.hightItem}"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 低库存指标:  </label>
            </td>
			<td class="value" width="85%">
                <input id="lowItem" class="inputxt" name="lowItem" value="${device.lowItem}"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr style="display:none" >
			<td align="right" width="25%" nowrap>
                <label class="Validform_label"> 参考价格:  </label>
            </td>
			<td class="value" width="85%">
                <input id="refPrice" class="inputxt" name="refPrice" value="${device.refPrice}"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
	</table>
</t:formvalid>
</body>