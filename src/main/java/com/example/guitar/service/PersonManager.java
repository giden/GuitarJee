package com.example.guitar.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.guitar.domain.Guitar;
import com.example.guitar.domain.Person;
import com.example.guitar.domain.Type;

@Stateless
public class PersonManager {

	@PersistenceContext
	EntityManager em;

	public void addPerson(Person person) {
		person.setId(null);
		em.persist(person);
	}

	public void deletePerson(Person person) {
		person = em.find(Person.class, person.getId());
		em.remove(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		return em.createNamedQuery("person.all").getResultList();
	}

	public List<Guitar> getOwnedGuitars(Person person) {
		person = em.find(Person.class, person.getId());

		List<Guitar> cars = new ArrayList<Guitar>(person.getGuitars());
		return cars;
	}
	
	public void updatePerson(Person person) {
	em.merge(person);
		
	}
	
	public void setName(String name, Long personId){
		Person person = em.find(Person.class, personId);
		person.setFirstName(name);
		em.merge(person);

		
	}

}
