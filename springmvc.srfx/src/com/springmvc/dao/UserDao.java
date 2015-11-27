package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.User;


public interface UserDao{
	
	public void add(User u);
	public List<User> selectUsers();
}
