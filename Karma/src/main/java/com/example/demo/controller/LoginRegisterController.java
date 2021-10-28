package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Usuario;
import com.example.demo.services.UsuarioService;

@Controller
public class LoginRegisterController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/auth/login")
	public String loginForm(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "login";
	}
	
	@GetMapping("/auth/register")
	public String registerForm(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "registro";
	}
	
	@PostMapping("/auth/register")
	public String register(@ModelAttribute Usuario usuario, Model model) {
		model.addAttribute("usuario",usuarioService.register(usuario));
		return "redirect:/auth/login";
	}

}
