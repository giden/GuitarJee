package com.example.guitar.web;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userBean", eager = true)
@SessionScoped
public class UserBean {
	
	
	private String user;

	public UserBean(String user) {
		this.user = user;
	}
	
	public UserBean(){
		
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String toString(){
		return user;
	}
	
}