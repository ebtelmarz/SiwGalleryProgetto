package it.uniroma3.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.model.Artista;
import it.uniroma3.model.Opera;
import it.uniroma3.services.ArtistaService;
import it.uniroma3.services.OperaService;
@Controller
@ComponentScan(basePackages="it.uniroma3.services")
public class OperaController {

	@Autowired
	private ArtistaService aservice;
	@Autowired
	private OperaService oservice;

  @PostMapping("/aggiuntaOpere")
  public String aggiungiOpera(@Valid@ModelAttribute Opera opera,@PathVariable Long id, Model model){
	  Artista artista=aservice.findbyId(id);
	  opera.setArtista(artista);
	  oservice.add(opera);
	  model.addAttribute("opera",opera);
	return "resocontoArtista";
	  
  }
  @PostMapping("/eliminaOpera")
  public String eliminaOpera(@ModelAttribute Opera opera){
	  oservice.delete(opera);
	  return "resocontoArtista";
  }
  @RequestMapping("/paginaOpera/{id}")
  public String paginaOpera(@PathVariable Long id,Model model){
	  model.addAttribute("opera", oservice.findbyId(id));
	  return "resocontoOpera";
  }
	
}
