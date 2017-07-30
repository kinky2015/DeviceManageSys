<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="exitDetailList" title="库存明细" checkbox="true" pagination="true" actionUrl="exitDocDetail.do?docAllDetail" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="sumPrice" sortOrder="asc">
	<t:dgCol title="ID" field="id" hidden="true"></t:dgCol>
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
</t:datagrid>
<script>
	//删除客户资料信息
	function delExitDetail(id)
	{
		var tabName= 'exitDetailList';
		var url= 'exitDocDetail.do?deleteExitDetail&id='+id;
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
		
		var row = $("#exitDetailList").datagrid("getSelected");
		var detailId="";
		if(row != null)
		{
			detailId = row.id;
		}
		
		
		var storeNo = $("#storeId").val();
		if(storeNo == null || storeNo == "" || storeNo == "undefined")
		{
			alert("请选择仓库信息");
			return;
		}
		
		//入库单号和入库类型
		var exitDocNo = $("#exitDocNo").val();
		var exitDocType = $("#exitDocType").val();
		
		url='exitDocDetail.do?addorupdate&id='+detailId+'&storeId='+storeNo+'&exitDocNo='+exitDocNo+'&exitDocType='+exitDocType;
		
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
		    	var saveUrl = "exitDocDetail.do?saveExitDetail&" + postData;
		    	console.log(saveUrl);
		    	$.ajax({
		    		type:"get",
		    		url: saveUrl,
		    		data:{},
		    		dataType:"json",
		    		success:function(data)
		    		{
		    			$("#exitDetailList").datagrid("reload");	
		    		}
		    	});
		    	
				return true;
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
	}
</script>