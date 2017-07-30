package com.jeecg.pro.equipment.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.p3.core.utils.common.StringUtils;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.pro.equipment.entity.StoreEntity;
import com.jeecg.pro.equipment.service.IStoreService;

@Controller
@RequestMapping("/store")
public class StoreController extends BaseController
{
	@Resource(name="storeServiceImpl")
	private IStoreService storeServiceImpl;
	
	@RequestMapping(params="list")
	public ModelAndView getList()
	{
		return new ModelAndView("equipment/store/storeList");
	}
	
	@RequestMapping(params="datagrid")
	public void dataGrid(StoreEntity store, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		CriteriaQuery cq = new CriteriaQuery(StoreEntity.class, dataGrid);
		//查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, store);
        cq.add();
        this.storeServiceImpl.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params="deleteStore")
	@ResponseBody
	public AjaxJson delete(StoreEntity store, HttpServletRequest req) 
	{
		AjaxJson result = new AjaxJson();
		this.storeServiceImpl.delete(store);
		return result;
	}
	
	@RequestMapping(params="deleteBatch")
	@ResponseBody
	public AjaxJson deleteBatch(String ids, HttpServletRequest req) 
	{
		AjaxJson result = new AjaxJson();
		List<String> storeIds = Arrays.asList(ids.split(","));
		for(String storeId : storeIds)
		{
			StoreEntity store = this.storeServiceImpl.findUniqueByProperty(StoreEntity.class, "id", storeId);
			this.storeServiceImpl.delete(store);
		}
		return result;
	}
	
	@RequestMapping(params="addorupdate")
	public ModelAndView addorupdate(StoreEntity store, HttpServletRequest req)
	{
		if(!StringUtils.isEmpty(store.getId()))
		{
			store = this.storeServiceImpl.getEntity(StoreEntity.class, store.getId());
			req.setAttribute("store", store);
		}
		return new ModelAndView("equipment/store/store");
	}
	
	@RequestMapping(params="saveStore")
	@ResponseBody
	public AjaxJson saveStore(StoreEntity store, HttpServletRequest req)
	{
		AjaxJson result = new AjaxJson();
		String orgIds = req.getParameter("orgIds");
		TSDepart tsDepart = new TSDepart();
		tsDepart.setId(orgIds);
		store.setTsDepart(tsDepart);
		if(StringUtils.isEmpty(store.getId()))
		{
			store.setId(this.storeServiceImpl.getStoreNo());
			this.storeServiceImpl.save(store);
		}
		else
		{
			this.storeServiceImpl.updateEntitie(store);
		}
		
		return result;
	}
	
	@RequestMapping(params="exportXls", produces="text/html;charset=UTF-8")
	public String exportXls(StoreEntity store, HttpServletRequest request, 
			HttpServletResponse response, DataGrid dataGrid, ModelMap modelMap) 
	{
		CriteriaQuery cq = new CriteriaQuery(StoreEntity.class, dataGrid);
		//查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, store);
        cq.add();
		List<StoreEntity> results = this.storeServiceImpl.getListByCriteriaQuery(cq, false);
		for(StoreEntity result : results)
		{
			result.setDepartName(result.getTsDepart().getDepartname());
		}
		modelMap.put(NormalExcelConstants.FILE_NAME,"仓库信息");
		modelMap.put(NormalExcelConstants.CLASS,StoreEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("仓库信息", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
				"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,results);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }
	
	@RequestMapping(params="storeRead")
	public ModelAndView storeRead()
	{
		return new ModelAndView("equipment/store/storeRead");
	}
	
	@RequestMapping(params="datagridRead")
	public void datagridRead(StoreEntity store,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		CriteriaQuery cq = new CriteriaQuery(StoreEntity.class, dataGrid);
		//查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, store);
        cq.add();
        this.storeServiceImpl.getDataGridReturn(cq, false);
        TagUtil.datagrid(response, dataGrid);
	}
}
