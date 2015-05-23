package com.example.guitar.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.guitar.domain.Guitar;
import com.example.guitar.domain.Type;

@Stateless
public class TypeManager {
	@PersistenceContext
	EntityManager em;

	public void addType(Type type) {
		type.setId(null);
		em.persist(type);
	}

	public void deleteType(Type type) {
		type = em.find(Type.class, type.getId());
		em.remove(type);
	}

	@SuppressWarnings("unchecked")
	public List<Type> getAllTypies() {
		return em.createNamedQuery("type.all").getResultList();
	}

	public List<Guitar> getGuitars(Type type) {
		type = em.find(Type.class, type.getId());

		List<Guitar> guitars = new ArrayList<Guitar>(type.getGuitars());
		return guitars;
	}
	public void deleteGuitar(Type type, Guitar guitar) {

		type = em.find(Type.class, type.getId());
		guitar = em.find(Guitar.class, guitar.getId());

		Guitar toRemove = null;

		for (Guitar aGuitar : type.getGuitars())
			if (aGuitar.getId().compareTo(guitar.getId()) == 0) {
				toRemove = aGuitar;
				break;
			}

		if (toRemove != null)
			type.getGuitars().remove(toRemove);
		
	}

	public void updateType(Type type) {
	
	em.merge(type);
		
	}
	

}

