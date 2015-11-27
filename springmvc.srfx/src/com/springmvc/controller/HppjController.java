package com.springmvc.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.dto.CheckInfo;
import com.springmvc.dto.HppjCheckInfo;
import com.springmvc.service.HppjService;
import com.springmvc.service.impl.HppjServiceImpl;

@Component
@RequestMapping(value = "/hppj.do")
@SessionAttributes({"hppjs","tbList","count"})//��ModelMap����������Ϊu��a���ٷ���session�С�������request��session�ж����ˡ�
public class HppjController {

	private HppjService hppjService;
	
	public HppjService getHppjService() {
		return hppjService;
	}
	@Resource
	public void setHppjService(HppjService hppjService) {
		this.hppjService = hppjService;
	}
	
	@RequestMapping(params="method=listHppj")
	public String listHppj(HppjCheckInfo hppjCheckInfo,ModelMap map){
		System.out.println(hppjCheckInfo.getCkdz());
		System.out.println(hppjCheckInfo.getP2());
			List hppjs = hppjService.hpList(hppjCheckInfo);
			List<String> tbList = hppjService.tableTittleList(hppjCheckInfo);
			System.out.println(hppjs);
			if(hppjs != null){
				map.addAttribute("tbList", tbList);
				map.addAttribute("hppjs",hppjs );
				map.addAttribute("count",tbList.size() );
			}else {
				map.addAttribute("tbList", "");
				map.addAttribute("count","");
				map.addAttribute("hppjs","");//hppjs���󶨿�ֵ����ѯ���Ϊ��ʱ����ҳ�治ˢ�£�Ϊ��һ�β�ѯ���
			}
			return "hppj";//return null;
	}
	//						<button id="excelExport">Excel Export</button>form��button���Ƿ���״̬error
	@RequestMapping(params="method=exportListHppj")
	public String exportListHppj(HppjCheckInfo hppjCheckInfo,ModelMap map){
			List hppjs = hppjService.hpList(hppjCheckInfo);
			List<String> tbList = hppjService.tableTittleList(hppjCheckInfo);
			
			hppjService.exportExcel(hppjs, tbList);
			
			if(hppjs != null){
				map.addAttribute("tbList", tbList);
				map.addAttribute("hppjs",hppjs );
				map.addAttribute("count",tbList.size() );
			}else {
				map.addAttribute("tbList", "");
				map.addAttribute("count","");
				map.addAttribute("hppjs","");//hppjs���󶨿�ֵ����ѯ���Ϊ��ʱ����ҳ�治ˢ�£�Ϊ��һ�β�ѯ���
			}
			return "hppj";//return null;
	}
	
	@RequestMapping(params="method=listHppj1")
	public String listHppj1(CheckInfo checkInfo){
		System.out.println(checkInfo.getStarttime()+"qqq");
		//System.out.println(hppjCheckInfo.getStarttime());
		//System.out.println(hppjCheckInfo.getP2());
		//map.addAttribute("hppjs", hppjService.hpList(hppjCheckInfo));
		return null;
	}
	
}
