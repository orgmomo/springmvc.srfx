package com.springmvc.service;


import java.util.List;
import java.util.Map;

import com.springmvc.dto.HppjCheckInfo;



public interface HppjService {
	public List hpList(HppjCheckInfo hppjCheckInfo);
	public List<String> tableTittleList(HppjCheckInfo hppjCheckInfo);
	public void exportExcel(List hppjs,List<String> tbList);
}
