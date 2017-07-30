package com.jeecg.pro.equipment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.pro.equipment.entity.DeviceInvEntity;
import com.jeecg.pro.equipment.service.IDeviceInvService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

@Controller
@RequestMapping("deviceInv")
public class DeviceInvController extends BaseController
{
	@Resource(name="deviceInvServiceImpl")
	private IDeviceInvService deviceInvServiceImpl;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params="getAll")
	public void getAllDeivceInv(DeviceInvEntity deviceInv, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		try
		{
			CriteriaQuery cq = new CriteriaQuery(DeviceInvEntity.class, dataGrid);
			//查询条件组装器
	        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, deviceInv);
	        cq.add();
	        this.deviceInvServiceImpl.getDataGridReturn(cq, false);
	        List<DeviceInvEntity> results = dataGrid.getResults();
	        if(results == null)
	        {
	        	results = new ArrayList<DeviceInvEntity>();
	        }
	        JsonConfig jsonConfig = new JsonConfig();
	        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
	        JSONArray  js = JSONArray .fromObject(results, jsonConfig);
	        response.getWriter().println(js.toString());
	        response.getWriter().flush();
	        response.getWriter().close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();;
		}   
	}
	
	@RequestMapping(params="getListPage")
	public ModelAndView getListPage(DeviceInvEntity deviceInv, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		CriteriaQuery cq = new CriteriaQuery(DeviceInvEntity.class, dataGrid);
		//查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, deviceInv);
        cq.add();
        this.deviceInvServiceImpl.getDataGridReturn(cq, false);
        List<DeviceInvEntity> results = dataGrid.getResults();
        if(results == null)
        {
        	results = new ArrayList<DeviceInvEntity>();
        }
        request.setAttribute("results", results);
		return new ModelAndView("equipment/deviceInv/deviceInvAllList");
	}
	
	@RequestMapping(params="list")
	public ModelAndView getList()
	{
		return new ModelAndView("equipment/deviceInv/deviceInvList");
	}
	
	@RequestMapping(params="datagrid")
	public void dataGrid(DeviceInvEntity deviceInv, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		CriteriaQuery cq = new CriteriaQuery(DeviceInvEntity.class, dataGrid);
		//查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, deviceInv);
        cq.add();
        this.deviceInvServiceImpl.getDataGridReturn(cq, false);
        TagUtil.datagrid(response, dataGrid);
	}
}
