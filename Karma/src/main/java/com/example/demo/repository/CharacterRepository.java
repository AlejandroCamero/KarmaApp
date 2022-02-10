package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Personaje;

@Repository
public interface CharacterRepository extends JpaRepository<Personaje,Long>{
	public Personaje findByName(String name);
	public List<Personaje> findByClase_id(Long id);
	public List<Personaje> findByViewOrderByNameAsc(boolean status);
}
