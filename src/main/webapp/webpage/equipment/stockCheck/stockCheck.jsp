<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div style="border:0px solid red;width:100%">
	<table style="width:100%">
		<tr>
			<td>
				<lable>仓库编号：</lable>
				<input name="storeId" type="text" value="" id="storeId" readonly="readonly" onclick="selectStore()" datatype="*"/> 
			</td>
			<td><lable>仓库名称：</lable><input id="storeName" name="storeName" disabled type="text"></td>
			<td><lable>仓库位置：</lable><input id="storePosition" name="storePosition" disabled type="text"></td>
		</tr>
	</table>
</div>
<t:datagrid name="stockCheckListNew" title="新增盘库信息" pagination="false" actionUrl="stockCheck.do?createNewInfo" fit="true" fitColumns="true" idField="id" queryMode="group" sortName="stockCheckNo" sortOrder="asc">
	<t:dgCol title="盘点库存主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="盘库编码" field="stockCheckNo" hidden="false" query="false"></t:dgCol>
	<t:dgCol title="设备编码" field="deviceInv.id" hidden="true"></t:dgCol>
	<t:dgCol title="设备编码" field="deviceInv.device.code" query="false"></t:dgCol>
	<t:dgCol title="设备编号" field="deviceInv.device.deviceNum" query="false"></t:dgCol>
	<t:dgCol title="设备名称" field="deviceInv.device.name" query="false"></t:dgCol>
	<t:dgCol title="仓库编号" field="deviceInv.store.id" query="false"></t:dgCol>
	<t:dgCol title="仓库名称" field="deviceInv.store.name" query="false"></t:dgCol>
	<t:dgCol title="仓库位置" field="deviceInv.store.position" query="false"></t:dgCol>
	<t:dgCol title="设备规格" field="deviceInv.device.deviceSpec"></t:dgCol>
	<t:dgCol title="单位" field="deviceInv.device.units.unit"></t:dgCol>
	<t:dgCol title="库存数量" field="deviceInv.count"></t:dgCol>
	<t:dgCol title="供应商编号" field="deviceInv.supplier.supplierNo"></t:dgCol>
	<t:dgCol title="供应商名称" field="deviceInv.supplier.supplierName"></t:dgCol>
	<t:dgCol title="期初库存" field="openInvCount"></t:dgCol>
	<t:dgCol title="期末库存" field="closeInvCount" extendParams="editor:'text'"></t:dgCol>
	<t:dgCol title="盈余数量" field="profitCount"></t:dgCol>
	<t:dgCol title="亏损数量" field="lossCount"></t:dgCol>
	
	<t:dgToolBar title="保存盘点记录" icon="icon-add" funname="saveStocCheckInfo"></t:dgToolBar>
</t:datagrid>

<script>
	var editIndex = undefined;  
	function endEditing() {//该方法用于关闭上一个焦点的editing状态  
	    if (editIndex == undefined) {  
	        return true  
	    }  
	    if ($('#stockCheckListNew').datagrid('validateRow', editIndex)) {  
	        $('#stockCheckListNew').datagrid('endEdit', editIndex);  
	        editIndex = undefined;  
	        return true;  
	    } else {  
	        return false;  
	    }  
	}  
	//点击单元格事件：  
	function onClickCell(index,field,value) {  
	    if (endEditing()) {  
	        if(field=="closeInvCount"){  
	            $("#stockCheckListNew").datagrid('beginEdit', index);  
	            var ed = $("#stockCheckListNew").datagrid('getEditor', {index:index, sfield:field});  
	        }
	        editIndex = index;  
	    } 
	}
	
	function onAfterEdit(index, row, changes) {  
	    //获取选中的行
		var row = $('#stockCheckListNew').datagrid('getSelected');
	    console.log(row);
	    
	    var closeInvCount = parseInt(row.closeInvCount);  //期末库存
	    var openInvCount = row.openInvCount;  //期初库存
	    var price = row["deviceInv.price"]; //单个价格  
	    if(openInvCount == "")
	    {
	    	row.openInvCount = 0;
	    }
	    
	    var count = parseInt(row['deviceInv.count']);
    	if(count == closeInvCount)   //正常
    	{
    		row.profitCount = 0;
	    	row.lossCount = 0;
	    	row.profitPrice = 0;
	    	row.lossPrice = 0;
    	}
    	else if(count > closeInvCount) //亏损
    	{
	    	row.lossCount = count - closeInvCount;
	    	row.lossPrice = (count - closeInvCount)*price;
	    	row.profitCount = 0;
	    	row.profitPrice = 0;
    	}
    	else if(count < closeInvCount) //盈利
    	{
    		row.profitCount = closeInvCount - count;
	    	row.profitPrice = (closeInvCount - count) * price;
	    	row.lossCount = 0;
	    	row.lossPrice = 0;
    	}
	    
	    //更新更改行数据
	    $('#stockCheckListNew').datagrid('updateRow', {index:index, row:row});
	} 
	
	$('#stockCheckListNew').datagrid({     
	    onClickCell: onClickCell,
	    onAfterEdit: onAfterEdit, 
	}); 

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
		    	
		    	$("#stockCheckListNew").datagrid("load",{"storeId":storeId});
		    	
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
	}
	
	function saveStocCheckInfo()
	{
		var storeId = $("#storeId").val();
		if(storeId == "" || storeId == null)
		{
			alert("请选择仓库信息");
			return;
		}
		
		//获取datagrid所有的数据
		var rows = $("#stockCheckListNew").datagrid("getRows");
		var url = "stockCheck.do?saveStocCheckInfo";
		var stocks = [];
		for(var i = 0; i < rows.length; i++)
		{
			var row = rows[i];
			console.log(rows[i]);
			var stock = 
			{
				stockCheckNo : row["stockCheckNo"],
				deviceInv:
				{
					id : row["deviceInv.id"]
				},
				openInvCount : row["openInvCount"],
				closeInvCount: row["closeInvCount"],
				profitCount : row["profitCount"],
				lossCount : row["lossCount"],
				profitPrice : row["profitPrice"],
				lossPrice : row["lossPrice"]
			};
			
			stocks.push(stock);
		}
		
		console.log(JSON.stringify(stocks))
		$.ajax({
			url : url,
			type : "post",
			dataType : "text",
			data : {stocks : JSON.stringify(stocks)},
			success : function(data)
			{
				alert("保存成功");
			}
		});
	}
</script>