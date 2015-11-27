package com.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity//(name="T_USER")
@Table(name="T_USER")
@SequenceGenerator(name="UserSQ",sequenceName="User_SQ",allocationSize=1)
public class User {
	private int id;
	private String username;
	private String password;
	
	public User(){}
	
	public User( String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="UserSQ")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
