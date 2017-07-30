package com.jeecg.pro.equipment.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MutiLangUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.pro.equipment.entity.Units;
import com.jeecg.pro.equipment.service.UnitService;
@Controller
@RequestMapping("/unitController")
public class UnitController extends BaseController{
	private static final Logger logger = Logger.getLogger(UnitController.class);
	@Autowired
	private UnitService unitService;
	@Autowired
	private SystemService systemService;
	@RequestMapping(params = "list")
	public ModelAndView getList()
	{
		return new ModelAndView("equipment/devmanage/unit/units");
	}
	@RequestMapping(params="datagrid", produces="text/html;charset=UTF-8")
	public void datagrid(Units unit, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) 
	{
		CriteriaQuery cq = new CriteriaQuery(Units.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, unit);
        cq.add();

        this.unitService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
    }

	@RequestMapping(params="addorupdate")
	public ModelAndView addorupdate(Units units, HttpServletRequest req) 
	{
		String id = units.getId();
		if(null!=id && StringUtil.isNotEmpty(id))
		{
			units = unitService.getEntity(Units.class, units.getId());
			req.setAttribute("addUnit", units);
		}
		
		return new ModelAndView("equipment/devmanage/unit/addUnit");
    }
	
	@RequestMapping(params="saveOrUpdate")
	@ResponseBody
	public AjaxJson saveUnitd(Units unit, HttpServletRequest req) 
	{
		String message = null;
		String id = unit.getId();
		AjaxJson ajaxJson = new AjaxJson();
		if (StringUtil.isNotEmpty(id)) {
			try {
				unitService.saveOrUpdate(unit);
				message = "编辑成功！";
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				message = "编辑失败！";
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			}
		} else {
		try {
			unit.setCode(getNum());
			unitService.save(unit);
			message = "保存成功！";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			message = "保存失败！";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}}
		ajaxJson.setMsg(message);
		return ajaxJson;
    }
	
	@RequestMapping(params="deleteSelectUnit")
	@ResponseBody
	public AjaxJson deleteSelectUnit(Units unit, HttpServletRequest req) 
	{
		String message = null;
		String id = req.getParameter("id");
		try {
			unitService.deleteEntityById(Units.class, id);
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
	
	@RequestMapping(params="deleteBatch")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request)
	{
		AjaxJson j = new AjaxJson();
		List<String> unitIds = Arrays.asList(ids.split(","));
		for (String id : unitIds) {
			unitService.deleteEntityById(Units.class, id);
		}
		return j;
	}
	/**
	 * 获取编号
	 * @return
	 */
	public String getNum()
	{
		// TODO Auto-generated method stub
		String maxNo = unitService.selectMaxNo();
		if(StringUtils.isEmpty(maxNo))
		{
			maxNo = "L0000001";
		}
		else
		{
			String str = "";
			maxNo = maxNo.replace("L", "");
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
			maxNo = "L" + str + (tmp + 1);
		}
		return maxNo;
	}
}
