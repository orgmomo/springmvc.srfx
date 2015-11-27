package com.springmvc.service;


import java.util.List;

import com.springmvc.model.User;

public interface UserService {

	public void save(User u);
	public List<User> findUsers();
	
}
