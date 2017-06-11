package it.uniroma3.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.model.Artista;
import it.uniroma3.services.ArtistaService;

@Controller
@ComponentScan(basePackages="it.uniroma3.services")
public class ArtistaController {

	@Autowired
	private ArtistaService aservice;

	@RequestMapping("/artisti")
	public String stampaArtisti(Model model){
		model.addAttribute("artisti",aservice.findAll());
		return "artisti";
	}

	
	@RequestMapping("/artistaAggiunta")
	@PostMapping("/artistaAggiunta")
	public String checkArtistaInfo(@Valid @ModelAttribute Artista artista, 
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "amministratoreArtista";
		}
		else {
			model.addAttribute(artista);
			aservice.add(artista);
		}
		return "amministratoreArtista";
	}
	@RequestMapping("/rimuoviArtista")
	@PostMapping("/rimuoviArtista")
	public String  rimozioneArtista(@ModelAttribute Artista artista, Model model){
	    model.addAttribute("artisti", aservice.findAll());
		aservice.delete(artista);
		return "vistaAmministratoreArtista";
	}
	
	@RequestMapping("/paginaArtista/{id}")
	public String paginaArtista(@PathVariable Long id, Model model){
		model.addAttribute("artista", aservice.findbyId(id));
		return "resocontoArtista";
	}

     


}
