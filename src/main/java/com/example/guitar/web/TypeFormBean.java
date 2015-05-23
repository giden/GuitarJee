package com.example.guitar.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.guitar.domain.Guitar;
import com.example.guitar.domain.Type;
import com.example.guitar.service.TypeManager;

@SessionScoped
@Named("typeBean")
public class TypeFormBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private Type type = new Type();
	private ListDataModel<Type> types = new ListDataModel<Type>();
	
	private Type typeToShow = new Type();
	public Type getTypeToShow() {
		return typeToShow;
	}

	private ListDataModel<Guitar> guitars = new ListDataModel<Guitar>();
	
	

	@Inject
	private TypeManager pm;
	

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public ListDataModel<Type> getAllTypies() {
		types.setWrappedData(pm.getAllTypies());
		return types;
	}
	

	public ListDataModel<Guitar> getGuitars() {
		guitars.setWrappedData(pm.getGuitars(typeToShow));
		return guitars;
	}
	
	// Actions
	public String addType() {
		pm.addType(type);
		return "showTypes?faces-redirect=true";
		//return null;
	}

	public String deleteType() {
		Type typesToDelete = types.getRowData();
		pm.deleteType(typesToDelete);
		return null;
	}
	public String updateType() {
		type = types.getRowData();
		return "updateType?faces-redirect=true";
	}
	
	public String update() {
		pm.updateType(type);
		return "showTypes?faces-redirect=true";
	}

	public String showDetails() {
		typeToShow = types.getRowData();
		return "detailsType";
	
	}
	
	public String deleteGuitar(){
		Guitar guitarToDelete = guitars.getRowData();
		pm.deleteGuitar(typeToShow, guitarToDelete);
		return null;
	}
}
