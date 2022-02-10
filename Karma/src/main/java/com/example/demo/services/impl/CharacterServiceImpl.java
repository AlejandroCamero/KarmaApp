package com.example.demo.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Personaje;
import com.example.demo.repository.CharacterRepository;
import com.example.demo.services.CharacterService;

@Service
public class CharacterServiceImpl implements CharacterService{
	
	@Autowired
	private CharacterRepository characterRepository;

	@Override
	public Personaje findByUsername(String username) {
		return characterRepository.findByName(username);
	}

	@Override
	public Personaje add(Personaje character) {
		return characterRepository.save(character);
	}



	@Override
	public Personaje findById(Long id) {
		Personaje finalChac=null;
		Optional<Personaje> chac = characterRepository.findById(id);
		finalChac=chac.get();
		return finalChac;
	}
	
	public void uploadFile(MultipartFile file) {
		try {
			file.transferTo(new File("\\static\\assets\\img\\"+file.getOriginalFilename()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Personaje> showAll() {
		return characterRepository.findAll();
	}

	@Override
	public List<Personaje> findByClase_id(Long long1) {
		return characterRepository.findByClase_id(long1);
	}
	
	public List<Personaje> findByViewOrderByNameAsc(boolean status){
		return characterRepository.findByViewOrderByNameAsc(status);
	}
	

}
