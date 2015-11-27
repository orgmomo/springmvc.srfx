package com.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.UserDao;
import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService{

	private UserDao userDao;

	@Override
	public void save(User u) {
		userDao.add(u);
		
	}
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public List<User> findUsers() {
		
		return userDao.selectUsers();
	}
}
