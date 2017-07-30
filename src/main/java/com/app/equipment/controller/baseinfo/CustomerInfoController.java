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

import com.app.equipment.entity.baseinfo.CustomerInfoEntity;
import com.app.equipment.service.baseinfo.ICustomerInfoService;

@Controller
@RequestMapping("/customerInfo")
public class CustomerInfoController 
{
	@Autowired
	private ICustomerInfoService customerInfoServiceImpl;
	
	@RequestMapping(params = "list")
	public ModelAndView getList()
	{
		return new ModelAndView("equipment/customer/customerList");
	}
	
	@RequestMapping(params="datagrid", produces="text/html;charset=UTF-8")
	public void datagrid(CustomerInfoEntity customer, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) 
	{
		customerInfoServiceImpl.getPageCustomer(customer, dataGrid);
		TagUtil.datagrid(response, dataGrid);
    }

	@RequestMapping(params="addorupdate")
	public ModelAndView addorupdate(CustomerInfoEntity customer, HttpServletRequest req) 
	{
		String customerNo = customer.getId();
		if(StringUtils.isEmpty(customerNo))
		{
			
		}
		else
		{
			customer = customerInfoServiceImpl.getCustomer(customerNo);
			req.setAttribute("customer", customer);
		}
		
		return new ModelAndView("equipment/customer/customer");
    }
	
	@RequestMapping(params="saveCustomer")
	@ResponseBody
	public AjaxJson saveCustomer(CustomerInfoEntity customer, HttpServletRequest req) 
	{
		AjaxJson ajaxJson = new AjaxJson();
		customerInfoServiceImpl.saveCustomer(customer);
		return ajaxJson;
    }
	
	@RequestMapping(params="deleteCustomer")
	@ResponseBody
	public AjaxJson deleteCustomer(CustomerInfoEntity customer, HttpServletRequest req) 
	{
		String customerNo = req.getParameter("id");
		customerInfoServiceImpl.deleteCustomer(customerNo);
		AjaxJson j = new AjaxJson();
		return j;
    }
	
	@RequestMapping(params="deleteBatch")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request)
	{
		AjaxJson j = new AjaxJson();
		List<String> customerNos = Arrays.asList(ids.split(","));
		customerInfoServiceImpl.deleteBatch(customerNos);
		return j;
	}
	
	@RequestMapping(params="exportXls", produces="text/html;charset=UTF-8")
	public String exportXls(CustomerInfoEntity customer, HttpServletRequest request, 
			HttpServletResponse response, DataGrid dataGrid, ModelMap modelMap) 
	{
		List<CustomerInfoEntity> results = customerInfoServiceImpl.getExportRecoders(customer);
		modelMap.put(NormalExcelConstants.FILE_NAME,"客户资料信息");
		modelMap.put(NormalExcelConstants.CLASS,CustomerInfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("客户资料信息", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
				"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,results);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }
}