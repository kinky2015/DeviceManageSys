package com.app.equipment.controller.baseinfo;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.p3.core.utils.common.StringUtils;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.equipment.entity.baseinfo.SupplierEntity;
import com.app.equipment.service.baseinfo.ISupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController 
{
	@Autowired
	private ISupplierService supplierServiceImpl;
	
	@RequestMapping(params = "list")
	public ModelAndView getList()
	{
		return new ModelAndView("equipment/supplier/supplierList");
	}
	
	@RequestMapping(params="datagrid", produces="text/html;charset=UTF-8")
	public void datagrid(SupplierEntity supplier, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) 
	{
		supplierServiceImpl.getPageSupplier(supplier, dataGrid);
		TagUtil.datagrid(response, dataGrid);
    }

	@RequestMapping(params="addorupdate")
	public ModelAndView addorupdate(SupplierEntity supplier, HttpServletRequest req) 
	{
		String supplierNo = supplier.getId();
		if(StringUtils.isEmpty(supplierNo))
		{
			
		}
		else
		{
			supplier = supplierServiceImpl.getSupplier(supplierNo);
			req.setAttribute("supplier", supplier);
		}
		
		return new ModelAndView("equipment/supplier/supplier");
    }
	
	@RequestMapping(params="saveSupplier")
	@ResponseBody
	public AjaxJson saveSupplier(SupplierEntity supplier, HttpServletRequest req) 
	{
		AjaxJson ajaxJson = new AjaxJson();
		supplierServiceImpl.saveSupplier(supplier);
		return ajaxJson;
    }
	
	@RequestMapping(params="deleteSupplier")
	@ResponseBody
	public AjaxJson deleteSupplier(SupplierEntity supplier, HttpServletRequest req) 
	{
		String supplierNo = req.getParameter("id");
		supplierServiceImpl.deleteSupplier(supplierNo);
		AjaxJson j = new AjaxJson();
		return j;
    }
	
	@RequestMapping(params="deleteBatch")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request)
	{
		AjaxJson j = new AjaxJson();
		List<String> supplierNos = Arrays.asList(ids.split(","));
		supplierServiceImpl.deleteBatch(supplierNos);
		return j;
	}
	
	@RequestMapping(params="exportXls", produces="text/html;charset=UTF-8")
	public String exportXls(SupplierEntity supplier, HttpServletRequest request, 
			HttpServletResponse response, DataGrid dataGrid, ModelMap modelMap) 
	{
		List<SupplierEntity> results = supplierServiceImpl.getExportRecoders(supplier);
		modelMap.put(NormalExcelConstants.FILE_NAME,"供应商信息");
		modelMap.put(NormalExcelConstants.CLASS,SupplierEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("供应商信息", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
				"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,results);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }
	
	@RequestMapping(params = "supplierRead")
	public ModelAndView supplierRead()
	{
		return new ModelAndView("equipment/supplier/supplierRead");
	}
	
	@RequestMapping(params="datagridRead", produces="text/html;charset=UTF-8")
	public void datagridRead(SupplierEntity supplier, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) 
	{
		supplierServiceImpl.getPageSupplier(supplier, dataGrid);
		TagUtil.datagrid(response, dataGrid);
    }
}