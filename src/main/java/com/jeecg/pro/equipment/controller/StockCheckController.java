package com.jeecg.pro.equipment.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.pro.equipment.entity.StockCheckEntity;
import com.jeecg.pro.equipment.service.IStockCheckService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/stockCheck")
public class StockCheckController extends BaseController 
{
	@Resource(name="stockCheckServiceImpl")
	private IStockCheckService stockCheckServiceImpl;
	
	@RequestMapping(params="list")
	public ModelAndView getList()
	{
		return new ModelAndView("equipment/stockCheck/stockCheckList");
	}
	
	@RequestMapping(params="datagrid")
	public void dataGrid(StockCheckEntity stock, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		CriteriaQuery cq = new CriteriaQuery(StockCheckEntity.class, dataGrid);
		//查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, stock);
        cq.add();
        this.stockCheckServiceImpl.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params="addorupdate")
	public ModelAndView addorupdate(StockCheckEntity stock, HttpServletRequest req)
	{		
		return new ModelAndView("equipment/stockCheck/stockCheck");
	}
	
	@RequestMapping(params="createNewInfo")
	public void createNewInfo(StockCheckEntity stock, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		String storeId = request.getParameter("storeId");
		List<StockCheckEntity> stocks = null;
		dataGrid.setResults(new ArrayList<Object>());
		if(!StringUtils.isEmpty(storeId))
		{
			stocks = this.stockCheckServiceImpl.createNewInfo(storeId);
		}
		else
		{
			stocks = new ArrayList<StockCheckEntity>();
		}
		dataGrid.getResults().addAll(stocks);
		
		TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params="saveStocCheckInfo")
	@ResponseBody
	public String saveStocCheckInfo(@RequestParam("stocks")String stocks)
	{
		JSONArray jsonArray = JSONArray.fromObject(stocks);  
		List<StockCheckEntity> results = JSONArray.toList(jsonArray, StockCheckEntity.class);
		for(StockCheckEntity result : results)
		{
			result.setModifyDate(new Date());
			result.setCreateDate(new Date());
		}
		this.stockCheckServiceImpl.batchSave(results);
		return "success";
	}
	
	@RequestMapping(params="deleteBatch")
	@ResponseBody
	public AjaxJson deleteBatch(String ids, HttpServletRequest req)
	{
		AjaxJson result = new AjaxJson();
		List<String> stockIds = Arrays.asList(ids.split(","));
		for(String stockId : stockIds)
		{
			StockCheckEntity stock = this.stockCheckServiceImpl.findUniqueByProperty(StockCheckEntity.class, "id", stockId);
			this.stockCheckServiceImpl.delete(stock);
		}
		return result;
	}
	
	@RequestMapping(params="stockModify")
	public ModelAndView stockModify(StockCheckEntity stock, HttpServletRequest req)
	{	
		StockCheckEntity result = this.stockCheckServiceImpl.getEntity(StockCheckEntity.class, stock.getId());
		req.setAttribute("result", result);
		return new ModelAndView("equipment/stockCheck/stockModify");
	}
	
	@RequestMapping(params="saveStockCheck")
	@ResponseBody
	public AjaxJson saveStockCheck(StockCheckEntity stock, HttpServletRequest req)
	{
		AjaxJson result = new AjaxJson();
		stock.setModifyDate(new Date());
		this.stockCheckServiceImpl.updateEntitie(stock);
		return result;
	}
}
