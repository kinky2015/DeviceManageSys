package com.jeecg.pro.equipment.service.impl;

import java.util.Map;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecg.pro.equipment.dao.ExitDocDao;
import com.jeecg.pro.equipment.service.IExitDocService;

@Service
public class ExitDocServiceImpl extends CommonServiceImpl implements IExitDocService
{
	@Autowired
	private ExitDocDao exitDocDao;
	@Override
	public String getExitDocNo() 
	{
		String exitDocNo = "";
		Map<String, Object> result = this.commonDao.findOneForJdbc("select max(exitDocNo) as exitDocNo from tbl_exit_Doc", null);
		if(result.get("exitDocNo") == null)
		{
			exitDocNo = "CKNO.0000001";
		}
		else
		{
			exitDocNo = result.get("exitDocNo").toString();
			exitDocNo = exitDocNo.replaceAll("CKNO.", "");
			long tmp = Long.parseLong(exitDocNo);
			tmp = tmp + 1;
			exitDocNo = "CKNO." + String.format("%07d", tmp);
		}
		return exitDocNo;
	}

	@Override
	public int selectMaxNo() {
		// TODO Auto-generated method stub
		return exitDocDao.selectMaxNo();
	}

}
