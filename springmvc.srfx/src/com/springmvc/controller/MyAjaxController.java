package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.User;


@Controller
@RequestMapping("myajax.do")
public class MyAjaxController {
	
	@RequestMapping(params="method=test1",method=RequestMethod.GET)
	public @ResponseBody List<User> test1(String uname) throws Exception{ 
		String uname2 = new String(uname.getBytes("iso8859-1"),"utf8");
		System.out.println(uname2); 
		System.out.println("MyAjaxController.test1()");
		List<User> list = new ArrayList<User>();
		list.add(new User("’‘√Ù","123"));
		list.add(new User("–°¡˙≈Æ","456"));
		
		return list;
	}
	
	
}
