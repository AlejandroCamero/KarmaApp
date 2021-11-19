package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Clase;
import com.example.demo.entity.Personaje;
import com.example.demo.services.impl.CharacterServiceImpl;
import com.example.demo.services.impl.ClaseServiceImpl;
import com.example.demo.upload.FileController;
import com.example.demo.upload.StorageService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private CharacterServiceImpl characterService;
	
	@Autowired
	private ClaseServiceImpl claseService;
	
	@GetMapping("/characters")
	public String viewAll(Model model) {
		List<Clase> clases = claseService.showAll();
		clases.add(new Clase((long) 0,"All",""));
		
		model.addAttribute("clases",clases);
		model.addAttribute("characters",characterService.showAll());
		return "admin/adminCharacters";
	}
	
	@PostMapping("/charactersClass")
	public String viewByClases(@RequestParam("clase") Long clase,Model model) {
		List<Clase> clases = claseService.showAll();
		
		clases.add(new Clase((long) 0,"All",""));
		model.addAttribute("clases",clases);
		if(clase==0) {
			return "redirect:/admin/characters";
		}else {
			model.addAttribute("characters",characterService.findByClase_id(clase));
		}
		
		return "admin/adminCharacters";
	}
	
	@PostMapping("/unpublicCharacter/{id}")
	public String unpublicCharacter(@PathVariable Long id,Model model) {
		Personaje personaje = characterService.findById(id);
		personaje.setView(false);
		model.addAttribute("character",characterService.add(personaje));
		return "redirect:/admin/characters";
	}
	
	@PostMapping("/publicCharacter/{id}")
	public String publicCharacter(@PathVariable Long id,Model model) {
		Personaje personaje = characterService.findById(id);
		personaje.setView(true);
		model.addAttribute("character",characterService.add(personaje));
		return "redirect:/admin/characters";
	}
	
	@GetMapping("/characterModify/{id}")
	public String modifyCharacter(@PathVariable Long id,Model model) {
		Personaje chac = characterService.findById(id);
		model.addAttribute("character",chac);
		model.addAttribute("clases",claseService.showAll());
		return "addCharacter";
	}
	
	@PostMapping("/post-character")
	public String add(@ModelAttribute Personaje character, Model model,@RequestParam("file") MultipartFile file, @RequestParam("clase") Long clase,RedirectAttributes redirAttrs) {
		if(file.isEmpty()) {
			Personaje c = characterService.findById(character.getId());
			character.setImage(c.getImage());
			character.setView(c.isView());
			model.addAttribute("character",characterService.add(character));
		}else {
			// String image=storageService.store(file, character.getId());
			// String[] path = MvcUriComponentsBuilder.fromMethodName(FileController.class, "serveFile", image).build().toUriString().split("/");
			
			Clase c= claseService.findById(clase).orElse(new Clase());
			character.setClase(c);
			// character.setImage(path[path.length-1]);
			model.addAttribute("character",characterService.add(character));
		}
		redirAttrs.addFlashAttribute("success", "The character was added succesfully");
		return "redirect:/admin/characters";
	}
	
	@GetMapping("/addCharacter")
	public String addForm(Model model) {
		model.addAttribute("character",new Personaje());
		model.addAttribute("clases",claseService.showAll());
		return "addCharacter";
	}

}
