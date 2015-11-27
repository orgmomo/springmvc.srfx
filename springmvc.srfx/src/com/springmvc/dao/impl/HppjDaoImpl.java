package com.springmvc.dao.impl;

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
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.springmvc.dao.HppjDao;


@Component("hppjDao")
public class HppjDaoImpl implements HppjDao {
	
	private SessionFactory sessionFactory;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List hppjList(String ksrq, String jsrq, String djmc,
			String pb, String lb, String xmh, String fz, String dz, String p2,
			String p4, String p7, String ckfz, String ckdz, String ckpl,
			String ckpb, String ckdjm, String ckxmh, String ckyjh,
			String ckywzl, String ckfhrmc) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="";
		String str ="";
		String strgb ="";
		String strtj ="";
		if(ckfz != null && ckfz.length() > 0){
			str = str+" hp.fzmc as ��վ,";
			strgb = strgb +",hp.fzmc";
		}
		if(ckdz != null && ckdz.length() > 0){
			str = str +"hp.dzmc as ��վ,";
			strgb = strgb +",hp.dzmc";
		}
		if(ckpl != null && ckpl.length() > 0){
			 if (p7 != null && p7.length() >0) {
				str = str+"substr(hp.pmdm,1,7) as Ʒ��,";
				strgb = strgb +",substr(hp.pmdm,1,7)";
			}else if(p4 != null && p4.length() >0){
				str = str+"substr(hp.pmdm,1,4) as Ʒ��,";
				strgb = strgb +",substr(hp.pmdm,1,4)";
			}else{
				str = str+"substr(hp.pmdm,1,2) as Ʒ��,";
				strgb = strgb +",substr(hp.pmdm,1,2)";
			}
		}
		if(ckpb != null && ckpb.length() > 0){
			str =str+"hp.pb as Ʊ��,";
			strgb = strgb +",hp.pb";
		}
		if(ckdjm != null && ckdjm.length() > 0){
			str =str+ "hp.djm as ������,";
			strgb = strgb +",hp.djm";
		}
		if(ckxmh != null && ckxmh.length() > 0){
			str =str+"hp.pzwh as ��׼�ĺ�,";
			strgb = strgb +",hp.pzwh";
		}
		if(ckyjh != null && ckyjh.length() > 0){
			str =str+ "hp.zyjh as �˼ۺ�,";
			strgb = strgb +",hp.zyjh";
		}
		if(ckywzl != null && ckywzl.length() > 0){
			str = str+"hp.ywzl as ҵ������,";
			strgb = strgb +",hp.ywzl";
		}
		if(ckfhrmc != null && ckfhrmc.length() > 0){
			str = str+"hp.fhrmc as ������,";
			strgb = strgb +",hp.fhrmc";
		}
		if(djmc != null && !djmc.equals("0")){
			strtj = " and hp.djm = '"+djmc+"'";
		}
		if(pb != null && !pb.equals("0")){
			strtj = strtj + " and hp.pb = '"+pb+"'";
		}
		if(lb != null && !lb.equals("-1")){
			strtj = strtj + " and hp.ywzl = '" +lb+"'";
		}
		if(xmh != null && xmh.length() > 0){
			strtj = strtj + " and hp.pzwh = '"+xmh+"'";
		}
		if(fz != null && fz.length() > 0){
			strtj = strtj + " and hp.fzmc in(" +splitString(fz)+")";
			
		}
		if(dz != null && dz.length() > 0){
			strtj = strtj +" and hp.dzmc in("+splitString(dz)+")";
		}
		if((p2 != null && p2.length() > 0) || (p4 != null && p4.length() > 0) ||(p7 != null && p7.length() > 0)){
			String spl2 ="";
			if(p2 != null && p2.length() > 0){
				String[] sp2 = splitString(p2).split(",");
				for(int i=0;i<sp2.length;i++){
					spl2 = spl2 +" or instr(substr(hp.pmdm,1,2),"+sp2[i]+")>0";
				} 
			}
			String spl4 ="";
			if(p4 != null && p4.length() > 0){
				String[] sp4 = splitString(p4).split(",");
				for(int i=0;i<sp4.length;i++){
					spl4 = spl4 +" or instr(substr(hp.pmdm,1,4),"+sp4[i]+")>0";
				} 
			}
			String spl7="";
			if(p7 != null && p7.length() > 0){
				spl7 =spl7+ " or hp.pmdm in( "+splitString(p7)+")";
			}
			strtj = strtj +" and ("+(spl2+spl4+spl7).substring(3)+")";
		}
		hql = "select "+str+" sum(hp.zjz/1000) as �ܼ���,sum(hp.zjz/1000*hp.zlc)as ��ת��,"+
					"(case when sum(hp.zjz/1000) > 0 then round(sum(hp.zjz/1000*hp.zlc)/sum(hp.zjz/1000)) else round(sum(hp.zlc)/sum(hp.zcxs)) end) as ƽ���˾�,"+
					"sum(hp.zcxs) as �ܳ���,sum(hp.zfy) as �ܷ���,sum(hp.jsjj) as �������,sum(hp.dlfj) as �������ӷ� "+
					" from Hppj hp where hp.jzrq >= '"+ksrq+"' and hp.jzrq <= '"+jsrq+"'"+strtj+ " group by "+strgb.substring(1); 		
		System.out.println(hql);
		Query qry = null;
		try {
			qry = session.createQuery(hql);
		} catch (Exception e) {
			System.out.println("������");
		}
		List hppjs = qry.list();
		//Collections.sort(hppjs,new MapComparator());
		if(hppjs != null && hppjs.size() > 0){
			return hppjs;
		}
		return null;
	}
	@Override
	public List<String> tableList(String ckfz, String ckdz, String ckpl,
			String ckpb, String ckdjm, String ckxmh, String ckyjh,
			String ckywzl, String ckfhrmc) {
		List<String> tbList = new ArrayList<String>();
		if(ckfz != null && ckfz.length() > 0){
			tbList.add("��վ");
		}
		if(ckdz != null && ckdz.length() > 0){
			tbList.add("��վ");
		}
		if(ckpl != null && ckpl.length() > 0){
			tbList.add("Ʒ��");
		}
		if(ckpb != null && ckpb.length() > 0){
			tbList.add("Ʊ��");
		}
		if(ckdjm != null && ckdjm.length() > 0){
			tbList.add("������");
		}
		if(ckxmh != null && ckxmh.length() > 0){
			tbList.add("��׼�ĺ�");
		}
		if(ckyjh != null && ckyjh.length() > 0){
			tbList.add("�˼ۺ�");
		}
		if(ckywzl != null && ckywzl.length() > 0){
			tbList.add("ҵ������");
		}
		if(ckfhrmc != null && ckfhrmc.length() > 0){
			tbList.add("������");
		}
		tbList.add("�ܼ���");
		tbList.add("��ת��");
		tbList.add("ƽ���˾�");
		tbList.add("�ܳ���");
		tbList.add("�ܷ���");
		tbList.add("�������");
		tbList.add("�������ӷ�");
		
		return tbList;
	}
	@Override
	public void tableToExcel(List hppjs,List<String> tbList){
		FileOutputStream fout = null;
		// 1.����excel�ļ�  
        try {
			fout = new FileOutputStream(new File("E:/Excel/"+new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date().getTime())+".xls"));
			//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date().getTime()).toString());
			 // 2.���ɹ�����  
	        WritableWorkbook wb = Workbook.createWorkbook(fout);  
	        // 3.���ɹ�����  
	        WritableSheet sheet = wb.createSheet("������1", 0);  
	        // 4.���ɵ�Ԫ��  
	        // 5.�������м��뵥Ԫ��  
	        for(int i=0;i<tbList.size();i++){
	        	Label label = new Label(i,0,tbList.get(i));
	        	sheet.addCell(label);  
	        }
	        
	        if(hppjs != null){
	        	List<Object[]> list =hppjs;
	        	/*for (Object[] obj : list) {
			        	for(int j=0;j<tbList.size();j++){
			        		 System.out.println(obj[j]);
			        	}

				}*/
	        	NumberFormat nf = new NumberFormat("#.##");
	        	WritableCellFormat wcfN = new WritableCellFormat(nf);
	        	for(int i=0;i<list.size();i++){
	        		for(int j=0;j<tbList.size();j++){
		        		 //System.out.println(list.get(i)[j]);
	        			if(j>=1 && j<= 4){
	        				Number label = new Number(j,i+1,(Long) list.get(i)[j]);
	        				sheet.addCell(label);
	        			}else if(j==5){
	        				Number label = new Number(j,i+1,(Double) list.get(i)[j]);
	        				sheet.addCell(label);
	        			}else {
							
	        				Label label = new Label(j,i+1,list.get(i)[j].toString());
	        				sheet.addCell(label);
						}
	        			/*Label label = new Label(j,i+1,list.get(i)[j].toString());
        				sheet.addCell(label);*/
		        	}
	        	}
	        }
	        
	        wb.write();
	        wb.close();
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String splitStr(String str){
		String str1 ="";
		String str4 ="";
		if(str != null && str.contains(" ")){
			String[] str2 = str.split(" ");
			for(int i=0;i<str2.length;i++){
				str1 = str1+","+ str2[i];
			}

			if(str1 != null && str1.length() > 0 && str1.contains("��")){
				String[] str3 = str1.split("��");
				for(int i=0;i<str3.length;i++){
					str4 = str4 +"," +str3[i];
				}

				return str4;
			}else {
				return str1;
			}
		}else if(str != null && str.contains("��")){
			String[] str2 = str.split("��");
			for(int i=0;i<str2.length;i++){
				str1 = str1 +","+str2[i];
			}
			return str1;
		}
		return str;
	}
	public String splitString(String str){
		String str1 ="";
		String[] str2 =  splitStr(str).split(",");
		for(int i=0;i<str2.length;i++){
			if(str2[i].length() > 0){	
				str1 =str1 +",'"+str2[i]+"'";
			}
		}
		//System.out.println(str1.substring(1));
		return str1.substring(1);
	}	
}
