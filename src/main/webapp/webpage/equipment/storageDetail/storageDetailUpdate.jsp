<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div style="border:0px solid red;width:100%">
	<table style="width:100%">
		<tr>
			<td><lable>入库单号：</lable><input disabled style="background:#CCCCCC" id="storageDocNo" value="${storageDoc.storageDocNo}" type="text"></td>
			<td>
				<lable>仓库编号：</lable>
				<input name="storeId" type="text" value="${storageDoc.store.id}" disabled style="background:#CCCCCC" id="storeId" readonly="readonly" datatype="*"/> 
			</td>
			<td><lable>仓库名称：</lable><input id="storeName" value="${storageDoc.store.name}" disabled style="background:#CCCCCC" name="storeName" disabled type="text"></td>
			<td><lable>仓库位置：</lable><input id="storePosition" name="storePosition" disabled style="background:#CCCCCC" value="${storageDoc.store.position}" disabled type="text"></td>
			<td><lable>部门：</lable><input disabled style="background:#CCCCCC"  type="text" value="${sessionScope.LOCAL_CLINET_USER.currentDepart.departname}"></td>
			
		</tr>
		<tr>
			<td><lable>入库类型：</lable><input disabled style="background:#CCCCCC" id="storageDocType" value="采购入库" type="text"></td>
			<td><lable>&nbsp;&nbsp;&nbsp;&nbsp;入库人：</lable><input disabled style="background:#CCCCCC" value="${sessionScope.LOCAL_CLINET_USER.userName}" type="text"></td>
			<td><lable>&nbsp;&nbsp;&nbsp;审核人：</lable><input disabled style="background:#CCCCCC"  value="${sessionScope.LOCAL_CLINET_USER.userName}" type="text"></td>
		</tr>
	</table>
</div>
<br>
<t:datagrid  height="100" name="storageDetailList" title="入库单明细记录" checkbox="true" pagination="true" actionUrl="storageDetail.do?datagrid&storageDocNo=${storageDoc.storageDocNo}" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="price" sortOrder="asc">
	<t:dgCol title="入库单明细主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="入库单号" field="storageDoc.storageDocNo"></t:dgCol>
	<t:dgCol title="设备编码" field="device.code" ></t:dgCol>
	<t:dgCol title="设备编号" field="device.deviceNum"></t:dgCol>

	<t:dgCol title="设备规格" field="device.deviceSpec"></t:dgCol>
	<t:dgCol title="单位" field="device.units.unit"></t:dgCol>
	<t:dgCol title="设备类别" field="device.tsCategory.name"></t:dgCol>
	<t:dgCol title="适用设备" field="device.suitDivce.name"></t:dgCol>
	<t:dgCol title="高库存指标" field="device.hightItem"></t:dgCol>
	<t:dgCol title="低库存指标" field="device.lowItem"></t:dgCol>
	<t:dgCol title="数量" field="count"></t:dgCol>
	<t:dgCol title="供应商编号" field="supplier.supplierNo"></t:dgCol>
	<t:dgCol title="供应商名称" field="supplier.supplierName"></t:dgCol>
	<t:dgCol title="备注" field="remark"></t:dgCol>
	<t:dgCol title="操作" field="opt" width="200"></t:dgCol>
	<t:dgFunOpt funname="delStorageDetail(id)" title="删除入库记录" urlclass="ace_button" urlStyle="background-color:#ec4758;" urlfont="fa-trash-o"></t:dgFunOpt>
	
	<t:dgToolBar title="新增入库记录" icon="icon-add" funname="saveDetail"></t:dgToolBar>
	<t:dgToolBar title="编辑入库记录" icon="icon-edit" funname="saveDetail"></t:dgToolBar>
	<t:dgToolBar title="删除入库记录" icon="icon-remove" url="storageDetail.do?deleteBatch" funname="deleteALLSelect"></t:dgToolBar>
	<t:dgToolBar title="导出" icon="icon-putout" funname="exportXls"></t:dgToolBar>
</t:datagrid>
<script>
	//删除客户资料信息
	function delStorageDetail(id)
	{
		var tabName= 'storageDetailList';
		var url= 'storageDetail.do?deleteStorageDetail&id='+id;
		$.dialog.confirm('你确认要删除此条记录吗？', function(){
			doSubmit(url,tabName);
		}, 
		function(){});
	}
	
	//导出Excel
	function exportXls() 
	{
		JeecgExcelExport("storageDetail.do?exportXls", "storageDetailList");
	}
	
	//选择仓库信息
	function selectStore()
	{
		var url="store.do?storeRead";
		$.dialog({
			content: 'url:'+url,
			lock : true,
			zIndex: getzIndex(),
			width:500,
			height:480,
			title:"仓库信息",
			opacity : 0.3,
			cache:false,
		    ok: function(){
		    	var iframe = this.iframe.contentWindow;
		    	var storeId = iframe.getstoreListSelections("id")[0];
		    	var storeName = iframe.getstoreListSelections("name")[0];
		    	var storePosition = iframe.getstoreListSelections("name")[0];
		    	$("#storeId").val(storeId);
		    	$("#storeName").val(storeName);
		    	$("#storePosition").val(storePosition);
		    	
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
	}
	
	function saveDetail()
	{
		
		var row = $("#storageDetailList").datagrid("getSelected");
		var detailId="";
		if(row != null)
		{
			detailId = row.id;
		}
		
		
		var storeNo = $("#storeId").val();
		if(storeNo == null || storeNo == "" || storeNo == "undefined")
		{
			alert("请选择供应商编号");
			return;
		}
		
		//入库单号和入库类型
		var storageDocNo = $("#storageDocNo").val();
		var storageDocType = $("#storageDocType").val();
		
		url='storageDetail.do?addorupdate&id='+detailId+'&storeId='+storeNo+'&storageDocNo='+storageDocNo+'&storageDocType='+storageDocType;
		
		$.dialog({
			content: 'url:'+url,
			lock : true,
			zIndex: getzIndex(),
			width:700,
			height:500,
			title: '入库记录明细新增',
			opacity : 0.3,
			cache:false,
		    ok: function()
		    {
		    	//搜集参数
		    	var iframe = this.iframe.contentWindow;
		    	var form = $('#formobj', iframe.document);
		    	var postData = form.serialize();
		    	var saveUrl = "storageDetail.do?saveStorageDetail&" + postData;
		    	console.log(saveUrl);
		    	$.ajax({
		    		type:"get",
		    		url: saveUrl,
		    		data:{},
		    		dataType:"json",
		    		success:function(data)
		    		{
		    			$("#storageDetailList").datagrid("reload");	
		    		}
		    	});
		    	
				return true;
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
		
		//add('新增入库记录', 'storageDetail.do?addorupdate&storeId='+storeNo+'&storageDocNo='+storageDocNo+'&storageDocType='+storageDocType)
	}
</script>