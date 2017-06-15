package it.uniroma3.controller;

import java.nio.BufferUnderflowException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.model.Artista;
import it.uniroma3.services.ArtistaService;
import it.uniroma3.services.OperaService;

@Controller
@ComponentScan(basePackages="it.uniroma3.services")
public class ArtistaController {

	@Autowired
	private ArtistaService aservice;
	@Autowired
	private OperaService oservice;

	@RequestMapping("/artisti")
	public String stampaArtisti(Model model){
		model.addAttribute("artisti",aservice.findAll());
		return "artisti";
	}
	
	@RequestMapping("/artista/{id}")
	public String paginaArtista(@PathVariable String id, Model model){
		model.addAttribute("artista", aservice.findbyId(Long.parseLong(id)));
		
		return "infoArtista";
	}
	
	@RequestMapping("/artistaAggiunta")
	public String formArtista(Artista artista){
		return "amministratoreArtista";
	}

	
	@PostMapping("/addArtista")
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

	@PostMapping("/rimuoviArtista")
	public String  rimozioneArtista(@RequestParam String id, Model model){

		Artista artista= aservice.findbyId(Long.parseLong(id));
		aservice.delete(artista);
		Iterable<Artista> artisti=aservice.findAll();
		model.addAttribute("artisti", artisti);
		return "vistaAmministratoreArtista";
	}
	@RequestMapping("/amministraArtista")
	public String ammArtista(Model model){
		model.addAttribute("artisti", aservice.findAll());
		return "vistaAmministratoreArtista";
	}

	@RequestMapping("/paginaArtista/{id}")
	public String paginaArtistaAmm(@PathVariable String id, Model model){
		model.addAttribute("artista", aservice.findbyId(Long.parseLong(id)));
		model.addAttribute("opere",oservice.findByArtistaId(Long.parseLong(id)));
		return "resocontoArtista";
	}




}
