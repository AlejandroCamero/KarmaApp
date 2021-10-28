package com.example.demo.services;



import com.example.demo.entity.Usuario;

public interface UsuarioService {
	public Usuario findByUsername(String username);
	public Usuario register(Usuario usuario);
}
