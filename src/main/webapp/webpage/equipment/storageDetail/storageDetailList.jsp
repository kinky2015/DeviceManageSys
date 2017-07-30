<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="storageDetailList" title="入库单明细记录" pagination="true" actionUrl="" fit="true" fitColumns="true" idField="id" queryMode="group">
	<t:dgCol title="入库单明细主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="入库单号" field="doc.storageDocNo"></t:dgCol>
	<t:dgCol title="设备编码" field="device.code" ></t:dgCol>
	<t:dgCol title="设备编号" field="device.deviceNum"></t:dgCol>
	<t:dgCol title="设备名称" field="device.name"></t:dgCol>
	<t:dgCol title="设备规格" field="device.deviceSpec"></t:dgCol>
	<t:dgCol title="设备类别" field="device.tsCategory.name"></t:dgCol>
	<t:dgCol title="资产编号" field="device.assetNum"></t:dgCol>
	<t:dgCol title="单位" field="device.units.unit"></t:dgCol>
	<t:dgCol title="价格" field="device.unitPrice"></t:dgCol>
	<t:dgCol title="生产商名称" field="device.manufacturer.name"></t:dgCol>
	<t:dgCol title="供应商名称" field="device.supplier.supplierName"></t:dgCol>
	<t:dgCol title="维修厂名称" field="device.maintenance.name"></t:dgCol>
	<t:dgCol title="合同名称" field="device.contractName"></t:dgCol>
	<t:dgCol title="合同编号" field="device.contractNum"></t:dgCol>
	<t:dgCol title="技术参数" field="device.technicalParam"></t:dgCol>
	<t:dgCol title="实物管理部门" field="device.objDepart"></t:dgCol>
	<t:dgCol title="实物管理部门责任人" field="device.zrUser"></t:dgCol>
	<t:dgCol title="使用保管部门" field="device.useDepart"></t:dgCol>
	<t:dgCol title="使用保管部门责任人" field="device.useUser"></t:dgCol>
	<t:dgCol title="验收人" field="device.ysUser"></t:dgCol>
	<t:dgCol title="资产增加方式" field="device.zczjfs"></t:dgCol>
	<t:dgCol title="启用日期" field="device.qyDate"></t:dgCol>
	<t:dgCol title="资产使用状况" field="device.tStype.typename"></t:dgCol>
	<t:dgCol title="出厂日期" field="device.ccDate"></t:dgCol>
	<t:dgCol title="购买日期" field="device.buyDate"></t:dgCol>
	<t:dgCol title="出产厂商编号" field="device.outNum"></t:dgCol>
	<t:dgCol title="资金源头" field="device.capital"></t:dgCol>
	<t:dgCol title="用途分类" field="device.usetype。typename"></t:dgCol>
	<t:dgCol title="附属设备编号" field="device.parentDevice.deviceNum"></t:dgCol>
	<t:dgCol title="数量" field="count"></t:dgCol>
	<t:dgCol title="库存价格" field="sumPrice"></t:dgCol>
	<t:dgCol title="备注" field="remark"></t:dgCol>
	
	<t:dgToolBar title="保存数据" icon="icon-save" funname="modifyDetail"></t:dgToolBar>
	<t:dgToolBar title="新增入库记录" icon="icon-add" funname="saveDetail"></t:dgToolBar>
	<t:dgToolBar title="编辑入库记录" icon="icon-edit" funname="modifyDetail"></t:dgToolBar>
	<t:dgToolBar title="删除入库记录" icon="icon-remove" funname="deleteDetail"></t:dgToolBar>
</t:datagrid>
<div style="border:0px solid red;width:100%">
	<table style="width:100%">
		<input id="storeId" type="hidden"/>
		<tr>
			<td><lable>入库单号：</lable><input readonly="readonly" id="storageDocNo" value="${storageDocNo}" type="text"></td>
			<td><lable>仓库名称：</lable><input id="storeName" name="storeName" readonly="readonly" onclick="selectStore();" type="text"></td>
			<td><lable>入库人员：</lable><input type="text" readonly="readonly" id="userName" onclick="selectUser(this);"></td>
			<td><lable>审核人：</lable><input type="text" readonly="readonly" id="reviewerId" onclick="selectUser(this);"></td>
		</tr>
	</table>
</div>
<script>
	function deleteDetail()
	{
		var row = $("#storageDetailList").datagrid('getSelected');
		var rowIndex = $('#storageDetailList').datagrid('getRowIndex', row);
		$('#storageDetailList').datagrid('deleteRow', rowIndex); 
		/*layer.confirm('您确定要删除记录吗？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
        	var row = $("#storageDetailList").datagrid('getSelected');
    		var rowIndex = $('#storageDetailList').datagrid('getRowIndex', row);
    		$('#storageDetailList').datagrid('deleteRow', rowIndex); 
    		this.css("display", "none")
    		return;
        }, function(){
            return;
        });*/ 
	}
	
	function modifyDetail()
	{
		var row = $("#storageDetailList").datagrid('getSelected');
		var data = JSON.stringify(row);
		$.dialog({
			content: 'url:storageDetail.do?addorupdate&data=' + encodeURI(data),
			lock : true,
			zIndex: getzIndex(),
			width:700,
			height:500,
			title: '入库记录明细新增',
			opacity : 0.3,
			cache:false,
		    ok: function()
		    {		    	
		    	var iframe = this.iframe.contentWindow;
		    	var data = getFormJonsData($('#formobj', iframe.document));
		    	$("#storageDetailList").datagrid('insertRow',{index:0, row:data})
		    	
				return true;
		    },
		    cancelVal: '关闭',
		    cancel: true 
		});
		
		/*$('#storageDetailList').datagrid('updateRow',{
			index: 0,
			row: {
				name: 'new name'
			}
		});*/
	}

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
		    	$("#storeId").val(storeId);
		    	$("#storeName").val(storeName);
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
	}
	
	function selectUser(obj)
	{
		var url="userController.do?userList";
		$.dialog({
			content: 'url:'+url,
			lock: true,
			zIndex: getzIndex(),
			width: 800,
			height: 480,
			title: "用户信息",
			opacity: 0.3,
			cache: false,
		    ok: function(){
		    	var iframe = this.iframe.contentWindow;
		    	var userName = iframe.getuserListSelections("userName")[0];
		    	$(obj).val(userName);
		    },
		    cancelVal: '关闭',
		    cancel: true 
		});
	}
	
	function saveDetail()
	{
		
		/*var row = $("#storageDetailList").datagrid("getSelected");
		var detailId="";
		if(row != null)
		{
			detailId = row.id;
		}
		
		
		var storeNo = $("#storeId").val();
		if(storeNo == null || storeNo == "" || storeNo == "undefined")
		{
			//alert("请选择仓库信息");
			//return;
		}
		
		//入库单号和入库类型
		var storageDocNo = $("#storageDocNo").val();
		var storageDocType = $("#storageDocType").val();
		
		url='storageDetail.do?addorupdate&id='+detailId+'&storeId='+storeNo+'&storageDocNo='+storageDocNo+'&storageDocType='+storageDocType;*/
		
		var storeNo = $("#storeId").val();
		if(storeNo == null || storeNo == "" || storeNo == "undefined")
		{
			//alert("请选择仓库信息");
			//return;
		}
		
		$.dialog({
			content: 'url:storageDetail.do?addorupdate',
			lock : true,
			zIndex: getzIndex(),
			width:700,
			height:500,
			title: '入库记录明细新增',
			opacity : 0.3,
			cache:false,
		    ok: function()
		    {
		    	/*var iframe = this.iframe.contentWindow;
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
		    	});*/
		    	
		    	var iframe = this.iframe.contentWindow;
		    	var data = getFormJonsData($('#formobj', iframe.document));
		    	$("#storageDetailList").datagrid('insertRow',{index:0, row:data})
		    	
				return true;
		    },
		    cancelVal: '关闭',
		    cancel: true 
		});
	}
	
	function getFormJonsData(form)
	{
		var data = {};
	    $.each(form.serializeArray(), function() {
	      data[this.name] = this.value;
	    });
	    return data;
	}
</script>