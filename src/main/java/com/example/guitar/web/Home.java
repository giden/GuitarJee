package com.example.guitar.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "home", eager = true)
@SessionScoped
public class Home {

   @ManagedProperty(value="#{userBean}")
   private UserBean userBean;

   private String user;

   public String getUser() {
      if(userBean != null){
         user = userBean.getUser();
      }       
      return user;
   }
   
   public String showHome() {
	         
	      return "home";
	   }
   
   public UserBean getUserBean() {
	return userBean;
   }

   public void setUserBean(UserBean userBean) {
	this.userBean = userBean;
   }

}