package com.example.guitar.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.guitar.domain.Guitar;
import com.example.guitar.domain.Person;
import com.example.guitar.service.PersonManager;
import com.example.guitar.service.SellingManager;

@SessionScoped
@Named("saleBean")
public class SaleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SellingManager sm;

	@Inject
	private PersonManager pm;

	private Long guitarId;
	private Long personId;
	
	public Long getGuitarId() {
		return guitarId;
	}
	public void setGuitarId(Long guitarId) {
		this.guitarId = guitarId;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public List<Guitar> getAvailableGuitars() {
		return sm.getAvailableGuitars();
	}

	public List<Person> getAllPersons() {
		return pm.getAllPersons();
	}

	public String sellGuitar() {
		sm.sellGuitar(personId, guitarId);
		return null;
	}
}
