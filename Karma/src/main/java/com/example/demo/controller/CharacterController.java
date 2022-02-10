package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Personaje;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.services.impl.CharacterServiceImpl;


@Controller
@RequestMapping("/public")
public class CharacterController {

	@Autowired
	private CharacterServiceImpl characterService;
	

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/characters")
	public String viewAll(Authentication auth,HttpSession session,Model model) {
		if(auth == null) {
			model.addAttribute("characters",characterService.findByViewOrderByNameAsc(true));
			return "characters";
		}else{
			String username = auth.getName();
			
			if(session.getAttribute("usuario")==null) {
				Usuario usuario = usuarioRepository.findByUsername(username);
				usuario.setPassword(null);
				session.setAttribute("usuario", usuario);
			}
			model.addAttribute("characters",characterService.findByViewOrderByNameAsc(true));
			return "characters";
		}
	}
	
	@GetMapping("/character/{id}")
	public String viewCharacter(@PathVariable Long id,Model model) {
		Personaje chac = characterService.findById(id);
		String[] history = chac.getHistory().split(";");
		model.addAttribute("characters",chac);
		model.addAttribute("histories",history);
		return "character";
	}
	
	

	
	
	

}
