package com.springmvc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.springmvc.dao.UserDao;
import com.springmvc.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {
	
	private SessionFactory sessionFactory;
	
	@Override
	public void add(User u){
		System.out.println("UserDao.add()");
		Session session = sessionFactory.getCurrentSession();
		
		session.save(u);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> selectUsers() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<User> users =  session.createQuery("from User").list();
		
		return users;
	}

}
