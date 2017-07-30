package com.jeecg.pro.equipment.service.impl;

import java.util.Map;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;

import com.jeecg.pro.equipment.service.IDeviceService;

@Service
public class DeviceServiceImpl extends CommonServiceImpl implements IDeviceService 
{

	@Override
	public String getDeviceCode() 
	{
		String deviceCode = "";
		Map<String, Object> result = this.commonDao.findOneForJdbc("select max(code) as code from tbl_device", null);
		if(result.get("code") == null)
		{
			deviceCode = "SBNO.00000001";
		}
		else
		{
			deviceCode = result.get("code").toString();
			deviceCode = deviceCode.replaceAll("SBNO.", "");
			long tmp = Long.parseLong(deviceCode);
			tmp = tmp + 1;
			deviceCode = "SBNO." + String.format("%07d", tmp);
		}
		return deviceCode;
	}

}
