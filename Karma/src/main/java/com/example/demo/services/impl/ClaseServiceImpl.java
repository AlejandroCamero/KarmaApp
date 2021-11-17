package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Clase;
import com.example.demo.repository.ClaseRepository;
import com.example.demo.services.ClaseService;

@Service
public class ClaseServiceImpl implements ClaseService{
	
	@Autowired
	private ClaseRepository claseRepository;

	@Override
	public Clase findByName(String username) {
		return claseRepository.findByName(username);
	}

	@Override
	public Clase add(Clase c) {
		return claseRepository.save(c);
	}

	@Override
	public List<Clase> showAll() {
		return claseRepository.findAll();
	}

	@Override
	public Optional<Clase> findById(Long id) {
		return claseRepository.findById(id);
	}

}
