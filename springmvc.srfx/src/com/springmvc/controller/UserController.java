package com.springmvc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Component
@RequestMapping(value = "/user.do")
@SessionAttributes({"u","a","users"})//��ModelMap����������Ϊu��a���ٷ���session�С�������request��session�ж����ˡ�
public class UserController {

	private UserService userService;
	
	
	@RequestMapping(params="method=listUsers")
	public String listUsers(ModelMap map,String name){
		List<User> users = userService.findUsers();
		/*for (User user : users) {
			System.out.println(user.getUsername());
		}*/
		System.out.println(name);
		map.addAttribute("users", users);
		System.out.println("listUsers()");
		return "user";
		//����ֵΪnullҲ����,���鷵���ַ���
	}
	
	@RequestMapping(params="method=reg")
	public String reg(String username,String password){
		System.out.println("userController.reg()");
		System.out.println(username);
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		userService.save(u);
		return "index";
	}
	
	@RequestMapping(params="method=reg2")
	public String reg2(User user){
		System.out.println("userController.reg()");
		System.out.println(user.getUsername());
		userService.save(user);
		return "index";
	}
	
	//һ�����ڽ�ָ����������������������β�,��username������ֵ����name����Ȼ��
	//�������������ƺ��β����Ʊ���һ�£�����Ҫ����д��
	@RequestMapping(params="method=reg3")
	public String reg3(@RequestParam("username")String name,ModelMap map,HttpServletRequest req){
		System.out.println("userController.reg3()");
		
		req.getSession().setAttribute("b", "session��Χȡֵ");
		
		//map.addAttribute("a", "nihao");
		map.put("a", "request��Χȡֵ");		//modelMap����������request
		
		return "index";
	}
	
	@RequestMapping(params="method=reg4")
	public String reg4(@ModelAttribute("a")String name){
		System.out.println("userController.reg4()");
		System.out.println(name+"   ��session�����ȡ");
		
		return "index";
	}
	@RequestMapping(params="method=reg5")
	public String reg5(ModelMap map) {

//		return "forward:index.jsp";
//		return "forward:user.do?method=reg3"; //ת��
//		return "redirect:user.do?method=reg3";  //�ض���
		return "redirect:http://www.baidu.com";  //�ض���
	}

	@RequestMapping(params="method=reg6")
	public ModelAndView reg6(String username){
		//����import org.springframework.web.servlet.ModelAndView;
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("index");
//		mv.setView(new RedirectView("index"));

		
		User u = new User();
		u.setUsername("����");
		mv.addObject(u);//ֱ�ӷ������������Ϊ������ĸСд������user���� һ�㽨���ֶ������������ơ�
		mv.addObject("mv","mv����");
		return mv;
		
	}

	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
}
