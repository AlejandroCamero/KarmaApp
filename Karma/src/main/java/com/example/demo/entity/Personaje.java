package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Personaje implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String name,image,surname;
	
	@Lob
	private String history;
	
	@Min(1)@Max(40)
	private int strength;
	@Min(1)@Max(40)
	private int skill;
	@Min(1)@Max(40)
	private int constitution;
	@Min(1)@Max(40)
	private int intelligence;
	@Min(1)@Max(40)
	private int wisdom;
	@Min(1)@Max(40)
	private int karma;
	
	private int positive;
	private int negative;
	
	private boolean view;
	
	@ManyToOne
	@JoinColumn(name="clase_id")
	private Clase clase;

	public Personaje(long id, String name, String image, String surname, String history, @Min(1) @Max(40) int strength,
			@Min(1) @Max(40) int skill, @Min(1) @Max(40) int constitution, @Min(1) @Max(40) int intelligence,
			@Min(1) @Max(40) int wisdom, @Min(1) @Max(40) int karma, int positive, int negative, boolean view,
			Clase clase) {
		super();
		Id = id;
		this.name = name;
		this.image = image;
		this.surname = surname;
		this.history = history;
		this.strength = strength;
		this.skill = skill;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.karma = karma;
		this.positive = positive;
		this.negative = negative;
		this.view = view;
		this.clase = clase;
	}

	public Personaje() {
		super();
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
	}

	public int getPositive() {
		return positive;
	}

	public void setPositive(int positive) {
		this.positive = positive;
	}

	public int getNegative() {
		return negative;
	}

	public void setNegative(int negative) {
		this.negative = negative;
	}
	
	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean isView() {
		return view;
	}

	public void setView(boolean view) {
		this.view = view;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	@Override
	public String toString() {
		return "Personaje [Id=" + Id + ", name=" + name + ", image=" + image + ", history=" + history + ", strength="
				+ strength + ", skill=" + skill + ", constitution=" + constitution + ", intelligence=" + intelligence
				+ ", wisdom=" + wisdom + ", karma=" + karma + ", positive=" + positive + ", negative=" + negative + "]";
	}

}
