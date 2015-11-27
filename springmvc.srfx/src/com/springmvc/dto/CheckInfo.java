package com.springmvc.dto;

import java.util.Date;

public class CheckInfo {
	public String getStarttime() {
		return starttime;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}


	public String getEndtime() {
		return endtime;
	}


	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}


	private String starttime;
	private String endtime;
	
	
	public CheckInfo(String starttime, String endtime) {
		super();
		this.starttime = starttime;
		this.endtime = endtime;
	}


	public CheckInfo(){
		
	}



}
