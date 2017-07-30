package com.jeecg.pro.equipment.service.impl;

import java.util.Map;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;

import com.jeecg.pro.equipment.service.IStorageDocService;

@Service("storageDocServiceImpl")
public class StorageDocServiceImpl extends CommonServiceImpl implements IStorageDocService
{

	@Override
	public String getStorageDocNo() 
	{
		String storeNo = "";
		Map<String, Object> result = this.commonDao.findOneForJdbc("select max(storageDocNo) as storageDocNo from tbl_storage_doc", null);
		if(result.get("storageDocNo") == null)
		{
			storeNo = "RKNO.0000001";
		}
		else
		{
			storeNo = result.get("storageDocNo").toString();
			storeNo = storeNo.replaceAll("RKNO.", "");
			long tmp = Long.parseLong(storeNo);
			tmp = tmp + 1;
			storeNo = "RKNO." + String.format("%07d", tmp);
		}
		return storeNo;
	}

}
