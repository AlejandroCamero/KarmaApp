package com.example.demo.services;

import java.util.List;
import com.example.demo.entity.Personaje;

public interface CharacterService {
	public Personaje findByUsername(String username);
	public Personaje add(Personaje character);
	public List<Personaje> showAll();
	public Personaje findById(Long id);
	public List<Personaje> findByClase_id(Long clase);
	public List<Personaje> findByViewOrderByName(boolean status);
}
