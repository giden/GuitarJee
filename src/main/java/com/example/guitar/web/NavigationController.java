package com.example.guitar.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public String processPage1(){
		return "page";
		}
		public String processPage2(){
		return "page";
		}
}