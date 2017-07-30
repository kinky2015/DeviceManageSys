package com.jeecg.pro.equipment.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.p3.core.utils.common.StringUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.equipment.entity.baseinfo.SupplierEntity;
import com.jeecg.pro.equipment.entity.DeviceInvEntity;
import com.jeecg.pro.equipment.entity.ExitDocDetailEntity;
import com.jeecg.pro.equipment.entity.ExitDocEntity;
import com.jeecg.pro.equipment.entity.StoreEntity;
import com.jeecg.pro.equipment.service.IExitDocDetailService;

@Controller
@RequestMapping("exitDocDetail")
public class ExitDocDetailController extends BaseController
{
	@Resource(name="exitDocDetailServiceImpl")
	private IExitDocDetailService exitDocDetailServiceImpl;
	
	@RequestMapping(params="list")
	public ModelAndView getList()
	{
		return new ModelAndView("equipment/exitDocDetail/exitDocDetailList");
	}
	
	@RequestMapping(params="datagrid")
	public void datagrid(ExitDocDetailEntity exitDocDetail, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
	{
		String exitDocNo = request.getParameter("exitDocNo");
		List<ExitDocEntity> exits = this.exitDocDetailServiceImpl.findByProperty(ExitDocEntity.class, "exitDocNo", exitDocNo);
		if(exits != null && exits.size() > 0)
		{
			String exitId = exits.get(0).getId();
			CriteriaQuery cq = new CriteriaQuery(ExitDocDetailEntity.class, dataGrid);
			cq.add(Restrictions.eq("exitDoc.id", exitId));
			//查询条件组装器
	        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, exitDocDetail);
	        cq.add();
	        this.exitDocDetailServiceImpl.getDataGridReturn(cq, true);
		}
		else
		{
			dataGrid.setResults(new ArrayList<Object>());
		}
        TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params="addorupdate")
	public ModelAndView addorupdate(ExitDocDetailEntity exitDetail, HttpServletRequest req)
	{
		//获取入库信息
		String storeId = req.getParameter("storeId");
		String exitDocNo = req.getParameter("exitDocNo");
		String exitDocType = req.getParameter("exitDocType");
		ModelAndView result = new ModelAndView("equipment/exitDocDetail/exitDocDetail");
		result.getModelMap().put("storeId", storeId);
		result.getModelMap().put("exitDocNo", exitDocNo);
		result.getModelMap().put("exitDocType", exitDocType);
		if(!StringUtils.isEmpty(exitDetail.getId()))
		{
			exitDetail = this.exitDocDetailServiceImpl.getEntity(ExitDocDetailEntity.class, exitDetail.getId());
			req.setAttribute("exitDetail", exitDetail);
		}
		return result;
	}
	
	@RequestMapping(params="saveExitDetail")
	@ResponseBody
	public AjaxJson saveExitDetail(ExitDocDetailEntity exitDocDetail, HttpServletRequest request)
	{
		AjaxJson result = new AjaxJson();
//		String storeId = request.getParameter("storeId");
//		String exitDocNo = request.getParameter("exitDocNo");
//		String exitDocType = request.getParameter("exitDocType");
//		
//		//判断数据库中是否存在出库单记录如果不存在进行插入，存在则不进行动作
//		ExitDocEntity exitDoc = new ExitDocEntity();
//		exitDoc.setExitDocNo(exitDocNo);
//		List<ExitDocEntity> exitDocs = this.exitDocDetailServiceImpl.findByProperty(ExitDocEntity.class, "exitDocNo", exitDocNo);
//		if(exitDocs == null || exitDocs.size() == 0)
//		{
//			//出库部门
//			TSDepart tsDepart = new TSDepart();
//			tsDepart.setId(exitDocDetail.getTsDepart().getId());
//			
//			//出库人
//			TSUser tsUser = (TSUser) request.getSession().getAttribute("LOCAL_CLINET_USER");
//			
//			//出库类型
//			ExitDocType type = new ExitDocType();
//			type.setId(String.valueOf(exitDocType.hashCode()));
//			type.setName(exitDocType);
//			
//			//仓库信息
//			StoreEntity store = new StoreEntity();
//			store.setId(storeId);
//
//			exitDoc.setTsDepart(tsDepart);
//			exitDoc.setTsUser(tsUser);
//			exitDoc.setExitDocType(type);
//			exitDoc.setReviewer(tsUser);
//			exitDoc.setStore(store);
//			exitDoc.setCreateDate(new Date());
//			
//			this.exitDocDetailServiceImpl.save(exitDoc);
//		}
//		else
//		{
//			exitDoc = exitDocs.get(0);
//		}
//		
//		//插入tbl_exitdocdetail（出库记录详细）
//		exitDocDetail.setExitDoc(exitDoc);
//		this.exitDocDetailServiceImpl.save(exitDocDetail);
//		
//		//插入出库设备选择供应商信息以及数目金额
//		List<ExitDeviceEntity> exitDevices = new ArrayList<ExitDeviceEntity>();
//		String selectSupplier = exitDocDetail.getSelectSupplier();
//		String selectPrice = exitDocDetail.getSelectPrice();
//		String selectCount = exitDocDetail.getSelectCount();
//		String selectSumPrice = exitDocDetail.getSelectSumPrice();
//		String selectDevInv = exitDocDetail.getSelectDevInv();
//		if(!StringUtils.isEmpty(selectSupplier))
//		{
//			String[] selectSuppliers = selectSupplier.split(",");
//			for(int i = 0; i < selectSuppliers.length; i++)
//			{
//				String supplierNo = selectSuppliers[i];
//				if(!StringUtils.isEmpty(supplierNo))
//				{
//					SupplierEntity supplier = new SupplierEntity();
//					supplier.setSupplierNo(supplierNo);
//					
//					ExitDeviceEntity exitDevice = new ExitDeviceEntity();
//					exitDevice.setSupplier(supplier);
//					exitDevice.setPrice(Float.parseFloat(selectPrice.split(",")[i]));
//					exitDevice.setCount(Integer.parseInt(selectCount.split(",")[i]));
//					exitDevice.setSumPrice(Float.parseFloat(selectSumPrice.split(",")[i]));
//					
//					exitDevice.setExitDocDetail(exitDocDetail);
//					exitDevices.add(exitDevice);
//					
//					//获取原有的库存信息
//					String devInvId = selectDevInv.split(",")[i];
//					DeviceInvEntity deviceInv = this.exitDocDetailServiceImpl.findUniqueByProperty(DeviceInvEntity.class, "id", devInvId);
//					deviceInv.setCount(deviceInv.getCount() - Integer.parseInt(selectCount.split(",")[i]));
//					deviceInv.setSumPrice(deviceInv.getSumPrice() - Float.parseFloat(selectSumPrice.split(",")[i]));
//					this.exitDocDetailServiceImpl.updateEntitie(deviceInv);
//				}
//			}
//			
//			this.exitDocDetailServiceImpl.batchSave(exitDevices);
//		}
		
		return result;
	}
	
	@RequestMapping(params="deleteExitDetail")
	@ResponseBody
	public AjaxJson deleteExitDetail(ExitDocDetailEntity exitDocDetail, HttpServletRequest request)
	{
		AjaxJson result = new AjaxJson();
		
//		String exitDocDetailId = exitDocDetail.getId();
//		
//		//先删除tbl_exitDevice表中的信息，根绝外键明细Id删除
//		List<ExitDeviceEntity> exitDevices = this.exitDocDetailServiceImpl.findByProperty(ExitDeviceEntity.class, "exitDocDetail.id", exitDocDetailId);
//		this.exitDocDetailServiceImpl.deleteAllEntitie(exitDevices);
//		
//		//在删除tbl_exitDocDetail表中的信息
//		this.exitDocDetailServiceImpl.deleteEntityById(ExitDocDetailEntity.class, exitDocDetailId);
		
		return result;
	}
	
	@RequestMapping(params="listAll")
	public ModelAndView getListAll()
	{
		return new ModelAndView("equipment/exitDocDetail/exitDocDetailAll");
	}
	
//	@RequestMapping(params="datagridList")
//	public void datagridList(ExitDeviceEntity exitDevice, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
//	{
//		CriteriaQuery cq = new CriteriaQuery(ExitDeviceEntity.class, dataGrid);
//		//查询条件组装器
//        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, exitDevice);
//        cq.add();
//        this.exitDocDetailServiceImpl.getDataGridReturn(cq, true);
//        TagUtil.datagrid(response, dataGrid);
//	}
}
