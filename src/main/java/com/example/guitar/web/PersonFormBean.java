package com.example.guitar.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.guitar.domain.Guitar;
import com.example.guitar.domain.Person;
import com.example.guitar.service.PersonManager;
import com.example.guitar.service.SellingManager;

@SessionScoped
@Named("personBean")
public class PersonFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static String name;
	private Person person = new Person();
	private ListDataModel<Person> persons = new ListDataModel<Person>();
	
	private Person personToShow = new Person();
	private ListDataModel<Guitar> ownedGuitars = new ListDataModel<Guitar>();

	@Inject
	private PersonManager pm;
	
	@Inject
	private SellingManager sm;

	
	
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		PersonFormBean.name = name;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	public Person getPersonToShow() {
		return personToShow;
	}
	public ListDataModel<Person> getAllPersons() {
		persons.setWrappedData(pm.getAllPersons());
		return persons;
	}

	public ListDataModel<Guitar> getOwnedGuitars() {
		ownedGuitars.setWrappedData(pm.getOwnedGuitars(personToShow));
		return ownedGuitars;
	}
	
	// Actions
	public String addPerson() {
		pm.addPerson(person);
		Long personId = person.getId();
		pm.setName(name, personId);
		return "showPersons?faces-redirect=true";
		//return null;
	}

	public String deletePerson() {
		Person personToDelete = persons.getRowData();
		pm.deletePerson(personToDelete);
		return null;
	}
	public String updatePerson() {
		person = persons.getRowData();
		return "updatePerson?faces-redirect=true";
	}
	
	public String update() {
		pm.updatePerson(person);
		return "showPersons?faces-redirect=true";
	}

	
	public String showDetails() {
		personToShow = persons.getRowData();
		return "details";
	}
	
	public String disposeGuitar(){
		Guitar guitarToDispose = ownedGuitars.getRowData();
		sm.disposeGuitar(personToShow, guitarToDispose);
		return null;
	}
	
	public void uniquePin(FacesContext context, UIComponent component,
			Object value) {

		String pin = (String) value;

		for (Person person : pm.getAllPersons()) {
			if (person.getPin().equalsIgnoreCase(pin)) {
				FacesMessage message = new FacesMessage(
						"Person with this ID already exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
}
	}
	}
