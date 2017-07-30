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
import org.jeecgframework.p3.core.utils.common.StringUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.pro.equipment.entity.DeviceEntity;
import com.jeecg.pro.equipment.service.IDeviceService;

@Controller
@RequestMapping("/device")
public class DeviceController extends BaseController
{
	@Resource(name="deviceServiceImpl")
	private IDeviceService deviceServiceImpl;
	
	@RequestMapping(params="list")
	public ModelAndView getList()
	{
		return new ModelAndView("equipment/device/deviceList");
	}
	
	@RequestMapping(params="datagrid")
	public void dataGrid(DeviceEntity device, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		CriteriaQuery cq = new CriteriaQuery(DeviceEntity.class, dataGrid);
		//查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, device);
        cq.add();
        this.deviceServiceImpl.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params="addorupdate")
	public ModelAndView addorupdate(DeviceEntity device, HttpServletRequest req)
	{
		if(!StringUtils.isEmpty(device.getId()))
		{
			device = this.deviceServiceImpl.getEntity(DeviceEntity.class, device.getId());
			req.setAttribute("device", device);
		}
		return new ModelAndView("equipment/device/device");
	}
	
	@RequestMapping(params="saveDevice")
	@ResponseBody
	public AjaxJson saveDevice(DeviceEntity device, HttpServletRequest req)
	{
		AjaxJson ajaxJson = new AjaxJson();
		String id = device.getId();
		if(StringUtils.isEmpty(id))
		{
			device.setCode(this.deviceServiceImpl.getDeviceCode());
			this.deviceServiceImpl.save(device);
		}
		else
		{
			this.deviceServiceImpl.updateEntitie(device);
		}
		return ajaxJson;
	}
	
	@RequestMapping(params="deleteDevice")
	@ResponseBody
	public AjaxJson delete(DeviceEntity device, HttpServletRequest req) 
	{
		AjaxJson result = new AjaxJson();
		this.deviceServiceImpl.delete(device);
		return result;
	}
	
	@RequestMapping(params="deleteBatch")
	@ResponseBody
	public AjaxJson deleteBatch(String ids, HttpServletRequest req) 
	{
		AjaxJson result = new AjaxJson();
		List<String> deviceIds = Arrays.asList(ids.split(","));
		for(String deviceId : deviceIds)
		{
			DeviceEntity device = this.deviceServiceImpl.findUniqueByProperty(DeviceEntity.class, "id", deviceId);
			this.deviceServiceImpl.delete(device);
		}
		return result;
	}
	
	@RequestMapping(params="deviceRead")
	public ModelAndView deviceRead()
	{
		return new ModelAndView("equipment/device/deviceRead");
	}
	
	@RequestMapping(params="datagridRead")
	public void datagridRead(DeviceEntity device, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		CriteriaQuery cq = new CriteriaQuery(DeviceEntity.class, dataGrid);
		//查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, device);
        cq.add();
        this.deviceServiceImpl.getDataGridReturn(cq, false);
        TagUtil.datagrid(response, dataGrid);
	}
}
