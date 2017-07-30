package com.jeecg.pro.equipment.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.pro.equipment.entity.StorageDetailEntity;
import com.jeecg.pro.equipment.entity.StorageDocEntity;
import com.jeecg.pro.equipment.service.IDeviceService;
import com.jeecg.pro.equipment.service.IStorageDetailSerivce;

@Controller
@RequestMapping("/storageDetail")
public class StorageDetailController extends BaseController
{
	@Resource(name="storageDetailSerivceImpl")
	private IStorageDetailSerivce storageDetailSerivceImpl;
	
	@Resource(name="deviceServiceImpl")
	private IDeviceService deviceServiceImpl;
	
	@RequestMapping(params="list")
	public ModelAndView getList()
	{
		return new ModelAndView("equipment/storageDetail/storageDetailList");
	}
	
	@RequestMapping(params="savaDetail")
	public AjaxJson savaDetail(HttpServletRequest request, HttpServletResponse response)
	{
		String docInfo = request.getParameter("docInfo");
		String details = request.getParameter("details");
		System.out.println(docInfo);
		System.out.println(details);
		return null;
	}
	
	@RequestMapping(params="datagrid")
	public void datagrid(StorageDetailEntity storageDetail, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
//		String storageDocNo = request.getParameter("storageDocNo");
//		List<StorageDocEntity> storages = this.storageDetailSerivceImpl.findByProperty(StorageDocEntity.class, "storageDocNo", storageDocNo);
//		if(storages != null && storages.size() > 0)
//		{
//			String storageId = storages.get(0).getId();
//			CriteriaQuery cq = new CriteriaQuery(StorageDetailEntity.class, dataGrid);
//			cq.add(Restrictions.eq("storageDoc.id", storageId));
//			//查询条件组装器
//	        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, storageDetail);
//	        cq.add();
//	        this.storageDetailSerivceImpl.getDataGridReturn(cq, true);
//		}
//		else
//		{
//			dataGrid.setResults(new ArrayList<Object>());
//		}
		
		dataGrid.setResults(new ArrayList<>());
        TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params="addorupdate")
	public ModelAndView addorupdate(StorageDetailEntity storageDetail, HttpServletRequest req)
	{
		//获取入库信息
//		String storeId = req.getParameter("storeId");
//		String storageDocNo = req.getParameter("storageDocNo");
//		String storageDocType = req.getParameter("storageDocType");
//		ModelAndView result = new ModelAndView("equipment/storageDetail/storageDetail");
//		result.getModelMap().put("storeId", storeId);
//		result.getModelMap().put("storageDocNo", storageDocNo);
//		result.getModelMap().put("storageDocType", storageDocType);
//		if(!StringUtils.isEmpty(storageDetail.getId()))
//		{
//			storageDetail = this.storageDetailSerivceImpl.getEntity(StorageDetailEntity.class, storageDetail.getId());
//			req.setAttribute("storageDetail", storageDetail);
//		}
		String data = req.getParameter("data");
		ModelAndView result = new ModelAndView("equipment/storageDetail/storageDetail");
		if(StringUtils.isEmpty(data))
		{
			String deviceCode = deviceServiceImpl.getDeviceCode();
			result.getModelMap().put("deviceCode", deviceCode);
		}
		else
		{
			result.getModelMap().put("data", data);
		}
		return result;
	}
	
	@RequestMapping(params="saveStorageDetail")
	@ResponseBody
	public AjaxJson saveStorageDetail(StorageDetailEntity storageDetail, HttpServletRequest req)
	{
		AjaxJson ajaxJson = new AjaxJson();
		
//		String detailId = storageDetail.getId();
//		//获取用户信息
//		TSUser user = (TSUser) req.getSession().getAttribute("LOCAL_CLINET_USER");
//		
//		//获取入库单信息
//		String storeId = req.getParameter("storeId");
//		String storageDocNo = req.getParameter("storageDocNo");
//		String storageDocType = req.getParameter("storageDocType");
//		
//		//部门
//		TSDepart tsDepart = new TSDepart();
//		tsDepart.setId(user.getCurrentDepart().getId());
//		
//		//入库类型
//		StorageDocTypeEntity type = new StorageDocTypeEntity();
//		type.setId(String.valueOf(storageDocType.hashCode()));
//		
//		//仓库信息
//		StoreEntity store = new StoreEntity();
//		store.setId(storeId);
//		
//		//创建入库单对象
//		StorageDocEntity storageDoc = new StorageDocEntity();
//		storageDoc.setStorageDocNo(storageDocNo);
//		storageDoc.setTsDepart(tsDepart);
//		storageDoc.setStorageDocType(type);
//		storageDoc.setTsUser(user);
//		storageDoc.setReviewer(user);
//		storageDoc.setStore(store);
//		
//		//如果入库单信息存在则不需要插入入库单，否则需要插入入库单
//		List<StorageDocEntity> queryStorageDocs = this.storageDetailSerivceImpl.findByProperty(StorageDocEntity.class, "storageDocNo", storageDocNo);
//		if(queryStorageDocs == null || queryStorageDocs.size() == 0)
//		{
//			this.storageDetailSerivceImpl.save(storageDoc);
//			queryStorageDocs = this.storageDetailSerivceImpl.findByProperty(StorageDocEntity.class, "storageDocNo", storageDocNo);
//		}
//		storageDetail.setStorageDoc(queryStorageDocs.get(0));
//		if(StringUtils.isEmpty(detailId))
//		{
//			this.storageDetailSerivceImpl.save(storageDetail);
//		}
//		else
//		{
//			this.storageDetailSerivceImpl.updateEntitie(storageDetail);
//		}
//		
//		//根据设备Id、供应商Id、价格判断tbl_deviceInv(设备库存表)是否存在记录，如果存在记录进行数量、总结累加，如果不存在进行插入
//		String hql = "From DeviceInvEntity devInv where devInv.device.id = '"+storageDetail.getDevice().getId()+"' and devInv.supplier.id='"+storageDetail.getSupplier().getSupplierNo()+"' and devInv.price=" + storageDetail.getPrice();
//		List<DeviceInvEntity> devoceInvs = this.storageDetailSerivceImpl.findByQueryString(hql);
//		if(devoceInvs != null && devoceInvs.size() > 0)
//		{
//			DeviceInvEntity devoceInv = devoceInvs.get(0);
//			devoceInv.setSumPrice(devoceInv.getSumPrice() + storageDetail.getSumPrice());
//			devoceInv.setCount(devoceInv.getCount() + storageDetail.getCount());
//			this.storageDetailSerivceImpl.saveOrUpdate(devoceInv);
//		}
//		else
//		{
//			DeviceInvEntity deviceInv = new DeviceInvEntity();
//			
//			deviceInv.setDevice(storageDetail.getDevice());
//			deviceInv.setSupplier(storageDetail.getSupplier());
//			deviceInv.setCount(storageDetail.getCount());
//			deviceInv.setPrice(storageDetail.getPrice());
//			deviceInv.setSumPrice(storageDetail.getSumPrice());
//			this.storageDetailSerivceImpl.save(deviceInv);
//		}
		
		return ajaxJson;
	}
	
	@RequestMapping(params="deleteStorageDetail")
	@ResponseBody
	public AjaxJson deleteStorageDetail(StorageDetailEntity storageDetail, HttpServletRequest req)
	{
		AjaxJson ajaxJson = new AjaxJson();
		this.storageDetailSerivceImpl.delete(storageDetail);
		return ajaxJson;
	}
	
	@RequestMapping(params="deleteBatch")
	@ResponseBody
	public AjaxJson deleteBatch(String ids, HttpServletRequest req) 
	{
		AjaxJson result = new AjaxJson();
		List<String> detailIds = Arrays.asList(ids.split(","));
		for(String detailId : detailIds)
		{
			StorageDetailEntity detail = this.storageDetailSerivceImpl.findUniqueByProperty(StorageDetailEntity.class, "id", detailId);
			this.storageDetailSerivceImpl.delete(detail);
		}
		return result;
	}
	
	@RequestMapping(params="datagridList")
	public void datagridList(StorageDetailEntity storageDetail, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		CriteriaQuery cq = new CriteriaQuery(StorageDetailEntity.class, dataGrid);
		//查询条件组装器
		cq.addOrder("storageDoc.storageDocNo", SortDirection.desc);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, storageDetail);
        cq.add();
        this.storageDetailSerivceImpl.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params="listAll")
	public ModelAndView getListAll()
	{
		return new ModelAndView("equipment/storageDetail/storageDetailAll");
	}
}
