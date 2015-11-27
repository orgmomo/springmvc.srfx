package com.springmvc.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.HppjDao;
import com.springmvc.dao.UserDao;
import com.springmvc.dto.HppjCheckInfo;
import com.springmvc.model.Hppj;
import com.springmvc.service.HppjService;

@Component("hppjService")
@Transactional
public class HppjServiceImpl implements HppjService{

	private HppjDao hppjDao;
	
	public HppjDao getHppjDao() {
		return hppjDao;
	}
	
	@Resource //没有注入，在49行调用userDao时，报空指针异常
	public void setHppjDao(HppjDao hppjDao) {
		this.hppjDao = hppjDao;
	}

	@Override
	public List hpList(HppjCheckInfo hppjCheckInfo) {
		List hppjs=null;
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
		Date starttime = null;
		Date endtime = null;
		try {
			starttime = format1.parse(hppjCheckInfo.getStarttime());
			endtime = format1.parse(hppjCheckInfo.getEndtime());
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("时间异常了！");
		}
		String ksrq = format2.format(starttime);
		String jsrq = format2.format(endtime);
		hppjs = hppjDao.hppjList(ksrq,jsrq,hppjCheckInfo.getDjmc(),hppjCheckInfo.getPb(),hppjCheckInfo.getLb(),
				hppjCheckInfo.getXmh(),hppjCheckInfo.getFz(),hppjCheckInfo.getDz(),hppjCheckInfo.getP2(), hppjCheckInfo.getP4(), 
				hppjCheckInfo.getP7(),hppjCheckInfo.getCkfz(),hppjCheckInfo.getCkdz(),hppjCheckInfo.getCkpl(), hppjCheckInfo.getCkpb(),
				hppjCheckInfo.getCkdjm(),  hppjCheckInfo.getCkxmh(),hppjCheckInfo.getCkyjh(),hppjCheckInfo.getCkywzl(),hppjCheckInfo.getCkfhrmc()
				  );
		if(hppjs != null&& hppjs.size()>0){
			
			return hppjs;
		}else {
			
			return null;
		}
	}

	@Override
	public List<String> tableTittleList(HppjCheckInfo hppjCheckInfo) {
		List<String> tbList = hppjDao.tableList(hppjCheckInfo.getCkfz(), hppjCheckInfo.getCkdz(),hppjCheckInfo.getCkpl(),
				hppjCheckInfo.getCkpb(), hppjCheckInfo.getCkdjm(),hppjCheckInfo.getCkxmh(),hppjCheckInfo.getCkyjh(),
				hppjCheckInfo.getCkywzl(),hppjCheckInfo.getCkfhrmc());
		return tbList;
	}

	@Override
	public void exportExcel(List hppjs,List<String> tbList) {
		hppjDao.tableToExcel(hppjs, tbList);
	}
	
}
