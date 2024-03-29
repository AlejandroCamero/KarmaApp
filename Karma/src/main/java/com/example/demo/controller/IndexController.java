package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Controller
@RequestMapping("/public")
public class IndexController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/index")
	public String index(Authentication auth,HttpSession session) {
		if(auth == null) {
			return "index";
		}else {
			String username = auth.getName();
			
			if(session.getAttribute("usuario")==null) {
				Usuario usuario = usuarioRepository.findByUsername(username);
				usuario.setPassword(null);
				session.setAttribute("usuario", usuario);
			}
			return "index";
		}
	}
	
	@GetMapping("/knowledge")
	public String knowledge() {
		return "knowledge";
	}
	
	@GetMapping("/classes")
	public String clases() {
		return "clases";
	}
	
	@GetMapping("/trailer")
	public String trailer() {
		return "trailer";
	}

}
