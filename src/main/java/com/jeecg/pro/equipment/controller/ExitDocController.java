package com.jeecg.pro.equipment.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.pro.equipment.entity.DeviceEntity;
import com.jeecg.pro.equipment.entity.ExitDocEntity;
import com.jeecg.pro.equipment.service.IExitDocService;

@Controller
@RequestMapping("exitDoc")
public class ExitDocController extends BaseController
{
	@Resource(name="exitDocServiceImpl")
	private IExitDocService exitDocServiceImpl;
	
	@RequestMapping(params="list")
	public ModelAndView getList()
	{
		ModelAndView result = new ModelAndView("equipment/exitDoc/exitDocList");
		result.getModel().put("exitDocNo", getNum());
		return result;
	}
	
	@RequestMapping(params="datagrid")
	public void datagrid(DeviceEntity device, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		System.out.println("ddd");
//		CriteriaQuery cq = new CriteriaQuery(DeviceEntity.class, dataGrid);
//		//查询条件组装器
//        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, device);
//        cq.add();
//        this.exitDocServiceImpl.getDataGridReturn(cq, true);
		dataGrid.setResults(new ArrayList<>());
        TagUtil.datagrid(response, dataGrid);
	}
	@RequestMapping(params="add")
	public ModelAndView add(HttpServletRequest req){
		ModelAndView reuslt = new ModelAndView("equipment/exitDocDetail/exitDocDetailList");
		
		return reuslt;
	}
	
	@RequestMapping(params="addorupdate")
	public ModelAndView addorupdate(ExitDocEntity exitDoc, HttpServletRequest req)
	{
		//获取入库单号
		String exitDocNo = this.exitDocServiceImpl.getExitDocNo();
		ModelAndView reuslt = new ModelAndView("equipment/exitDocDetail/exitDocDetailList");
		reuslt.getModel().put("exitDocNo", exitDocNo);
		return reuslt;
	}
	
	@RequestMapping(params="deleteExitDoc")
	@ResponseBody
	public AjaxJson deleteExitDoc(ExitDocEntity exitDoc, HttpServletRequest req)
	{
		AjaxJson result = new AjaxJson();
		
//		String exitDocId = exitDoc.getId();
//		
//		List<ExitDocDetailEntity> exitDocDetails = this.exitDocServiceImpl.findByProperty(ExitDocDetailEntity.class, "exitDoc.id", exitDocId);
//		if(exitDocDetails != null && exitDocDetails.size() > 0)
//		{
//			for(ExitDocDetailEntity exitDocDetail : exitDocDetails)
//			{
//				String exitDocDetailId = exitDocDetail.getId();
//				List<ExitDeviceEntity> exitDevices = this.exitDocServiceImpl.findByProperty(ExitDeviceEntity.class, "exitDocDetail.id", exitDocDetailId);
//				if(exitDevices != null && exitDevices.size() > 0)
//				{
//					this.exitDocServiceImpl.deleteAllEntitie(exitDevices);
//				}
//			}
//			
//			this.exitDocServiceImpl.deleteAllEntitie(exitDocDetails);
//		}
//		
//		this.exitDocServiceImpl.delete(exitDoc);
		
		return result;
	}
	
	@RequestMapping(params="deleteBatch")
	@ResponseBody
	public AjaxJson deleteBatch(String ids, HttpServletRequest req)
	{
		AjaxJson result = new AjaxJson();
		
//		String exitDocIds[] = ids.split(",");
//		for(String exitDocId : exitDocIds)
//		{
//			ExitDocEntity exitDoc = new ExitDocEntity();
//			exitDoc.setId(exitDocId);
//			
//			List<ExitDocDetailEntity> exitDocDetails = this.exitDocServiceImpl.findByProperty(ExitDocDetailEntity.class, "exitDoc.id", exitDocId);
//			if(exitDocDetails != null && exitDocDetails.size() > 0)
//			{
//				for(ExitDocDetailEntity exitDocDetail : exitDocDetails)
//				{
//					String exitDocDetailId = exitDocDetail.getId();
//					List<ExitDeviceEntity> exitDevices = this.exitDocServiceImpl.findByProperty(ExitDeviceEntity.class, "exitDocDetail.id", exitDocDetailId);
//					if(exitDevices != null && exitDevices.size() > 0)
//					{
//						this.exitDocServiceImpl.deleteAllEntitie(exitDevices);
//					}
//				}
//				
//				this.exitDocServiceImpl.deleteAllEntitie(exitDocDetails);
//			}
//			
//			this.exitDocServiceImpl.delete(exitDoc);
//		}
		
		return result;
	}
	
	@RequestMapping(params="queryDetail")
	public ModelAndView queryDetail(ExitDocEntity exitDoc, HttpServletRequest req)
	{
		//获取入库单号
		String exitDocId = exitDoc.getId();
		ExitDocEntity result = this.exitDocServiceImpl.findUniqueByProperty(ExitDocEntity.class, "id", exitDocId);
		ModelAndView reuslt = new ModelAndView("equipment/exitDocDetail/exitDocDetailQuery");
		reuslt.getModel().put("exitDoc", result);
		return reuslt;
	}
	
	@RequestMapping(params="updateDetail")
	public ModelAndView updateDetail(ExitDocEntity exitDoc, HttpServletRequest req)
	{
		//获取入库单号
		String exitDocId = exitDoc.getId();
		ExitDocEntity result = this.exitDocServiceImpl.findUniqueByProperty(ExitDocEntity.class, "id", exitDocId);
		ModelAndView reuslt = new ModelAndView("equipment/exitDocDetail/exitDocDetailUpdate");
		reuslt.getModel().put("exitDoc", result);
		return reuslt;
	}
	/**
	 * 获取编号
	 * @return
	 */
	public synchronized String getNum()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		// TODO Auto-generated method stub
		int maxNo = exitDocServiceImpl.selectMaxNo();
		Date date = new Date();
		int k=maxNo+1;
		DecimalFormat df = new DecimalFormat("000");
		String d = sdf.format(date);
		String n = df.format(k);
		StringBuffer sb = new StringBuffer();
		sb.append("CK").append(d).append(n);
		return sb.toString();
	}
}
