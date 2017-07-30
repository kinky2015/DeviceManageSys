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
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.pro.equipment.entity.StorageDetailEntity;
import com.jeecg.pro.equipment.entity.StorageDocEntity;
import com.jeecg.pro.equipment.service.IStorageDocService;

@Controller
@RequestMapping("/storageDoc")
public class StorageDocController extends BaseController
{
	@Resource(name="storageDocServiceImpl")
	private IStorageDocService storageDocServiceImpl;
	
	@RequestMapping(params="list")
	public ModelAndView getList()
	{
		String storageDocNo = this.storageDocServiceImpl.getStorageDocNo();
		ModelAndView result = new ModelAndView("equipment/storageDoc/storageDocList");
		result.getModel().put("storageDocNo", storageDocNo);
		return result;
	}
	
	@RequestMapping(params="datagrid")
	public void datagrid(StorageDocEntity storageDoc, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		CriteriaQuery cq = new CriteriaQuery(StorageDocEntity.class, dataGrid);
		//查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, storageDoc);
        cq.add();
        this.storageDocServiceImpl.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params="addorupdate")
	public ModelAndView addorupdate(StorageDocEntity storageDoc, HttpServletRequest req)
	{
		//获取入库单号
		String storageDocNo = this.storageDocServiceImpl.getStorageDocNo();
		ModelAndView reuslt = new ModelAndView("equipment/storageDetail/storageDetailList");
		reuslt.getModel().put("storageDocNo", storageDocNo);
		return reuslt;
	}
	
	@RequestMapping(params="deleteStorageDoc")
	@ResponseBody
	public AjaxJson deleteStorageDetail(StorageDocEntity storageDoc, HttpServletRequest req)
	{
		AjaxJson ajaxJson = new AjaxJson();
		String storageDocId = storageDoc.getId();
		
		//删除入库单同时需要删除清单记录
		this.storageDocServiceImpl.delete(storageDoc);
		List<StorageDetailEntity> details = this.storageDocServiceImpl.findByProperty(StorageDetailEntity.class, "storageDoc.id", storageDocId);
		this.storageDocServiceImpl.deleteAllEntitie(details);
		return ajaxJson;
	}
	
	@RequestMapping(params="deleteBatch")
	@ResponseBody
	public AjaxJson deleteBatch(String ids, HttpServletRequest req) 
	{
		AjaxJson result = new AjaxJson();
		List<String> docIds = Arrays.asList(ids.split(","));
		for(String docId : docIds)
		{
			this.storageDocServiceImpl.deleteEntityById(StorageDocEntity.class, docId);
			List<StorageDetailEntity> details = this.storageDocServiceImpl.findByProperty(StorageDetailEntity.class, "storageDoc.id", docId);
			this.storageDocServiceImpl.deleteAllEntitie(details);
		}
		return result;
	}
	
	@RequestMapping(params="queryDetail")
	public ModelAndView queryDetail(StorageDocEntity storageDoc, HttpServletRequest req)
	{
		//获取入库单号
		String storageDocId = storageDoc.getId();
		StorageDocEntity result = this.storageDocServiceImpl.findUniqueByProperty(StorageDocEntity.class, "id", storageDocId);
		ModelAndView reuslt = new ModelAndView("equipment/storageDetail/storageDetailQuery");
		reuslt.getModel().put("storageDoc", result);
		return reuslt;
	}
	
	@RequestMapping(params="updateDetail")
	public ModelAndView updateDetail(StorageDocEntity storageDoc, HttpServletRequest req)
	{
		//获取入库单号
		String storageDocId = storageDoc.getId();
		StorageDocEntity result = this.storageDocServiceImpl.findUniqueByProperty(StorageDocEntity.class, "id", storageDocId);
		ModelAndView reuslt = new ModelAndView("equipment/storageDetail/storageDetailUpdate");
		reuslt.getModel().put("storageDoc", result);
		return reuslt;
	}
}
