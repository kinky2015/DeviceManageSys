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

import com.jeecg.pro.equipment.entity.ManufacturerEntity;
import com.jeecg.pro.equipment.entity.Units;
import com.jeecg.pro.equipment.service.IManufacturerService;
/**
 * 生产厂商
 * @author jack
 *
 */
@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController extends BaseController{
	@Autowired
	private IManufacturerService manufacturerService;
	@Autowired
	private SystemService systemService;
	@RequestMapping(params = "view")
	public ModelAndView getList()
	{
		return new ModelAndView("equipment/manufacturer/manufacturerList");
	}
	@RequestMapping(params="datagrid", produces="text/html;charset=UTF-8")
	public void datagrid(ManufacturerEntity manufacturer, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) 
	{
		CriteriaQuery cq = new CriteriaQuery(ManufacturerEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, manufacturer);
        cq.add();

        this.manufacturerService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
    }
	@RequestMapping(params="addOrEdit")
	public ModelAndView addOrEdit(ManufacturerEntity manufacturer, HttpServletRequest req) 
	{
		String id = manufacturer.getId();
		if(null!=id && StringUtil.isNotEmpty(id))
		{
			manufacturer = manufacturerService.getEntity(ManufacturerEntity.class, manufacturer.getId());
			req.setAttribute("manufacturer", manufacturer);
		}
		
		return new ModelAndView("equipment/manufacturer/manufacturer");
    }
	@RequestMapping(params="saveOrUpdate")
	@ResponseBody
	public AjaxJson saveOrUpdate(ManufacturerEntity manufacturer, HttpServletRequest req) 
	{
		String message = null;
		String id = manufacturer.getId();
		AjaxJson ajaxJson = new AjaxJson();
		if (!StringUtil.isNotEmpty(id)) {
		try {
			manufacturer.setNum(getNum());
			manufacturerService.save(manufacturer);
			message = "保存成功！";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			message = "保存失败！";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}}else{
			try {
				manufacturerService.saveOrUpdate(manufacturer);
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
		List<String> manufacturerIds = Arrays.asList(ids.split(","));
		for (String id : manufacturerIds) {
			manufacturerService.deleteEntityById(ManufacturerEntity.class, id);
		}
		return j;
	}
	@RequestMapping(params="delete")
	@ResponseBody
	public AjaxJson delete(ManufacturerEntity manufacturer, HttpServletRequest req) 
	{
		String message = null;
		String id = req.getParameter("id");
		try {
			manufacturerService.deleteEntityById(ManufacturerEntity.class, id);
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
		String maxNo = manufacturerService.selectMaxNo();
		if(StringUtils.isEmpty(maxNo))
		{
			maxNo = "S0000001";
		}
		else
		{
			String str = "";
			maxNo = maxNo.replace("S", "");
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
			maxNo = "S" + str + (tmp + 1);
		}
		return maxNo;
	}
}
