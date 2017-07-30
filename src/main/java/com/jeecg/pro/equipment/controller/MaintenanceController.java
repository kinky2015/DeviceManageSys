package com.jeecg.pro.equipment.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.pro.equipment.entity.MaintenanceEntity;
import com.jeecg.pro.equipment.entity.MaintenanceEntity;
import com.jeecg.pro.equipment.service.IMaintenanceService;
/**
 * 维修厂商
 * @author jack
 *
 */
@Controller
@RequestMapping("/maintenance")
public class MaintenanceController extends BaseController{
	@Autowired
	private IMaintenanceService maintenanceService;
	@Autowired
	private SystemService systemService;
	@RequestMapping(params = "view")
	public ModelAndView getList()
	{
		return new ModelAndView("equipment/maintenance/maintenanceList");
	}
	@RequestMapping(params="datagrid", produces="text/html;charset=UTF-8")
	public void datagrid(MaintenanceEntity maintenance, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) 
	{
		CriteriaQuery cq = new CriteriaQuery(MaintenanceEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maintenance);
        cq.add();

        this.maintenanceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
    }
	@RequestMapping(params="addOrEdit")
	public ModelAndView addOrEdit(MaintenanceEntity maintenance, HttpServletRequest req) 
	{
		String id = maintenance.getId();
		if(null!=id && StringUtil.isNotEmpty(id))
		{
			maintenance = maintenanceService.getEntity(MaintenanceEntity.class, maintenance.getId());
			req.setAttribute("maintenance", maintenance);
		}
		
		return new ModelAndView("equipment/maintenance/maintenance");
    }
	@RequestMapping(params="saveOrUpdate")
	@ResponseBody
	public AjaxJson saveOrUpdate(MaintenanceEntity maintenance, HttpServletRequest req) 
	{
		String message = null;
		String id = maintenance.getId();
		AjaxJson ajaxJson = new AjaxJson();
		if (!StringUtil.isNotEmpty(id)) {
		try {
			maintenance.setNum(getNum());
			maintenanceService.save(maintenance);
			message = "保存成功！";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			message = "保存失败！";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}}else{
			try {
				maintenanceService.saveOrUpdate(maintenance);
				message = "编辑成功！";
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				message = "编辑失败！";
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			}
		}
		ajaxJson.setMsg(message);
		return ajaxJson;
	}
	@RequestMapping(params="deleteAll")
	@ResponseBody
	public AjaxJson deleteAll(String ids, HttpServletRequest req) 
	{
		AjaxJson j = new AjaxJson();
		List<String> maintenanceIds = Arrays.asList(ids.split(","));
		for (String id : maintenanceIds) {
			maintenanceService.deleteEntityById(MaintenanceEntity.class, id);
		}
		return j;
	}
	@RequestMapping(params="delete")
	@ResponseBody
	public AjaxJson delete(MaintenanceEntity maintenance, HttpServletRequest req) 
	{
		String message = null;
		String id = req.getParameter("id");
		try {
			maintenanceService.deleteEntityById(MaintenanceEntity.class, id);
			message="删除成功！";
		} catch (Exception e) {
			// TODO: handle exception
			message="删除失败！";
			e.printStackTrace();
		}
		
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.setMsg(message);
		return ajaxJson;
	}
	/**
	 * 获取编号
	 * @return
	 */
	public String getNum()
	{
		// TODO Auto-generated method stub
		String maxNo = maintenanceService.selectMaxNo();
		if(StringUtils.isEmpty(maxNo))
		{
			maxNo = "W0000001";
		}
		else
		{
			String str = "";
			maxNo = maxNo.replace("W", "");
			Long tmp = Long.parseLong(maxNo);
			Long nextTmp = tmp + 1;
			int nextLength = String.valueOf(nextTmp).length();
			int length = 7 - nextLength;
			if(length != 0 )
			{
				for(int i = 0; i < length; i++)
				{
					str = str + "0";
				}
			}
			maxNo = "W" + str + (tmp + 1);
		}
		return maxNo;
	}
}
