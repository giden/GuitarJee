package com.example.guitar.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "type.all", query = "Select p from Type p")
})
public class Type {

	private Long id;
	private String name="";
	private String description="";
	
	List<Guitar> guitars = new ArrayList<Guitar>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2, max = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Size(min = 0, max = 50)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany
	@JoinColumn(name="type_fk")
	public List<Guitar> getGuitars() {
		return guitars;
	}
	public void setGuitars(List<Guitar> guitars) {
		this.guitars = guitars;
	}
	
	
}
