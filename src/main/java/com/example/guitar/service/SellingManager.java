package com.example.guitar.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.guitar.domain.Guitar;
import com.example.guitar.domain.Person;


/* 
 * This is a Stateless EJB Bean
 * All its methods are transactional
 */
@Stateless
public class SellingManager {

	@PersistenceContext
	EntityManager em;

	public void sellGuitar(Long personId, Long guitarId) {

		Person person = em.find(Person.class, personId);
		Guitar guitar = em.find(Guitar.class, guitarId);
		guitar.setSold(true);

		person.getGuitars().add(guitar);
	}
	
	

	@SuppressWarnings("unchecked")
	public List<Guitar> getAvailableGuitars() {
		return em.createNamedQuery("guitar.unsold").getResultList();
	}

	public void disposeGuitar(Person person, Guitar guitar) {

		person = em.find(Person.class, person.getId());
		guitar = em.find(Guitar.class, guitar.getId());

		Guitar toRemove = null;

		for (Guitar aGuitar : person.getGuitars())
			if (aGuitar.getId().compareTo(guitar.getId()) == 0) {
				toRemove = aGuitar;
				break;
			}

		if (toRemove != null)
			person.getGuitars().remove(toRemove);
		
		guitar.setSold(false);
	}
}
