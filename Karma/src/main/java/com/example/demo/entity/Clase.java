package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class Clase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="clase")
	private List<Personaje> personajes;
	
	public Clase() {
		super();
	}

	public Clase(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}
	
	public void add(Personaje p) {
		personajes.add(p);
	}

	@Override
	public String toString() {
		return "Clase [id=" + id + ", name=" + name + ", description=" + description + ", personajes=" + personajes
				+ "]";
	}

	
}
