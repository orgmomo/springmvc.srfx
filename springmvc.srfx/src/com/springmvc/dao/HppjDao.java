package com.springmvc.dao;

import java.util.List;

public interface HppjDao{
	
	 public List hppjList(String ksrq,String jsrq,String djmc,String pb,String lb,String xmh,
				String fz,String dz,String p2, String p4, String p7, String ckfz,String ckdz,String ckpl,
				String ckpb, String ckdjm,String ckxmh,String ckyjh,String ckywzl,String ckfhrmc);
	 public List<String> tableList(String ckfz, String ckdz, String ckpl,
				String ckpb, String ckdjm, String ckxmh, String ckyjh,
				String ckywzl, String ckfhrmc);
	 public void tableToExcel(List hppjs,List<String> tbList);
}
