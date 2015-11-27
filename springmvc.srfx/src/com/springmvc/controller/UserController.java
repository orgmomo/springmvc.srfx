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
@SessionAttributes({"u","a","users"})//将ModelMap中属性名字为u、a的再放入session中。这样，request和session中都有了。
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
		//返回值为null也可以,建议返回字符串
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
	
	//一般用于将指定的请求参数付给方法中形参,将username参数的值付给name。当然，
	//如果请求参数名称和形参名称保持一致，则不需要这种写法
	@RequestMapping(params="method=reg3")
	public String reg3(@RequestParam("username")String name,ModelMap map,HttpServletRequest req){
		System.out.println("userController.reg3()");
		
		req.getSession().setAttribute("b", "session范围取值");
		
		//map.addAttribute("a", "nihao");
		map.put("a", "request范围取值");		//modelMap的作用域是request
		
		return "index";
	}
	
	@RequestMapping(params="method=reg4")
	public String reg4(@ModelAttribute("a")String name){
		System.out.println("userController.reg4()");
		System.out.println(name+"   从session里面获取");
		
		return "index";
	}
	@RequestMapping(params="method=reg5")
	public String reg5(ModelMap map) {

//		return "forward:index.jsp";
//		return "forward:user.do?method=reg3"; //转发
//		return "redirect:user.do?method=reg3";  //重定向
		return "redirect:http://www.baidu.com";  //重定向
	}

	@RequestMapping(params="method=reg6")
	public ModelAndView reg6(String username){
		//导入import org.springframework.web.servlet.ModelAndView;
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("index");
//		mv.setView(new RedirectView("index"));

		
		User u = new User();
		u.setUsername("李四");
		mv.addObject(u);//直接放入对象。属性名为”首字母小写的类名user”。 一般建议手动增加属性名称。
		mv.addObject("mv","mv测试");
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
