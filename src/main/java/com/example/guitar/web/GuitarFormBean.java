package com.example.guitar.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.guitar.domain.Guitar;
import com.example.guitar.service.GuitarManager;

@SessionScoped
@Named("guitarBean")
public class GuitarFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Guitar guitar = new Guitar();
	private Long typeId;
	private String year;



	private ListDataModel<Guitar> guitars = new ListDataModel<Guitar>();
	

	@Inject
	private GuitarManager gm;


	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	
	public Guitar getGuitar() {
		return guitar;
	}

	public void setGuitar(Guitar guitar) {
		this.guitar = guitar;
	}

	public ListDataModel<Guitar> getAllGuitars() {
		guitars.setWrappedData(gm.getAllGuitars());
		return guitars;
	}
	
	public ListDataModel<Guitar> getGuitarByYear() {
		guitars.setWrappedData(gm.findGuitarByYear(year));
		return guitars;
	}
	
	public ListDataModel<Guitar> getGuitarByType() {
		guitars.setWrappedData(gm.findGuitarByType(typeId));
		return guitars;
	}
	
	public String searchGuitarType() {
		return "showGuitarsType";
		//return null;
		
	}

	public String searchGuitar() {
		return "showGuitarsYear";
		//return null;
		
	}
	
	// Actions
	public String addGuitar() {
		gm.addGuitar(guitar);
		
		gm.setType(typeId, guitar.getId());

		return "showGuitars?faces-redirect=true";
		//return null;
		
	}

	public String deleteGuitar() {
		Guitar guitarToDelete = guitars.getRowData();
		gm.deleteGuitar(guitarToDelete);
		return null;
	}
	
	public String updateGuitar() {
		guitar = guitars.getRowData();
		return "updateGuitar?faces-redirect=true";
	}
	
	public String update() {
		gm.updateGuitar(guitar);
		
		gm.setType(typeId, guitar.getId());
		
		return "showGuitars?faces-redirect=true";
	}
	
}
