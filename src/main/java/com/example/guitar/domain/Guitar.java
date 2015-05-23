package com.example.guitar.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
@NamedQuery(name = "guitar.unsold", query = "Select c from Guitar c where c.sold = false"),
@NamedQuery(name = "guitar.all", query = "Select p from Guitar p"),
@NamedQuery(name = "guitar.byYear", query = "Select p from Guitar p where p.year = :year"),
@NamedQuery(name = "guitar.byType", query = "Select p from Guitar p where p.type = :type")

})
public class Guitar {
	
	private Long id;
	private String year = "";
	private String maker = "";
	private Boolean sold = false;
	
	private Type type;
	private Person person;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Size(min = 4, max=4)
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	@Size(min = 3, max=30)
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public Boolean getSold() {
		return sold;
	}
	public void setSold(Boolean sold) {
		this.sold = sold;
	}
	
	
	@ManyToOne
    @JoinColumn(name="person_fk", insertable=false, updatable=false)
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	
	@ManyToOne
    @JoinColumn(name="type_fk", insertable=false, updatable=false)
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	
}
