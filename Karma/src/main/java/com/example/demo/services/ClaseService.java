package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Clase;

public interface ClaseService {
	public Clase findByName(String username);
	public Clase add(Clase c);
	public List<Clase> showAll();
	public Optional<Clase> findById(Long id);
}
