package com.example.guitar.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.guitar.domain.Guitar;
import com.example.guitar.domain.Type;

@Stateless
public class GuitarManager {

	@PersistenceContext
	EntityManager em;

	public void addGuitar(Guitar guitar) {
		guitar.setId(null);
		em.persist(guitar);
	}

	public void deleteGuitar(Guitar guitar) {
		guitar = em.find(Guitar.class, guitar.getId());
		em.remove(guitar);
	}
	
	public Type assignType(Long typeId) {

		Type type = em.find(Type.class, typeId);
		return type;
	}
	

	@SuppressWarnings("unchecked")
	public List<Guitar> getAllGuitars() {
		return em.createNamedQuery("guitar.all").getResultList();
	}

	

	public void setType(Long typeId, Long guitarId) {
		Type type = em.find(Type.class, typeId);
		Guitar guitar = em.find(Guitar.class, guitarId);

		type.getGuitars().add(guitar);
	}
	
	@SuppressWarnings("unchecked")
	public List <Guitar> findGuitarByYear(String year){
		return (List<Guitar>) em.createNamedQuery("guitar.byYear").setParameter("year", year).getResultList();

	}
	
	@SuppressWarnings("unchecked")
	public List <Guitar> findGuitarByType(Long typeId){
		Type type = em.find(Type.class, typeId);
		return (List<Guitar>) em.createNamedQuery("guitar.byType").setParameter("type", type).getResultList();

	}
	
	public void updateGuitar(Guitar guitar) {
		
		em.merge(guitar);
			
		}

}
