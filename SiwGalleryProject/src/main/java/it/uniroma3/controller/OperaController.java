package it.uniroma3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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

	
//	public String vistaFormOpere(Model model){
	//	model.addAttribute("opera",new Opera());
		//model.addAttribute("artista",new Artista());
//		model.addAttribute("artisti", aservice.findAll());	
	//	return "amministratoreOpera";

//	}
	
	@GetMapping("/recuperaArtista")
	public String selectArtista(HttpServletRequest request, Model model){
		model.asMap().put("id",request.getParameter("id"));
		return "amministratoreOpera";
	}
	@RequestMapping("/aggiuntaOpere")
	@PostMapping("/aggiuntaOpere")
	public String formOpera(@Valid@ModelAttribute Opera opera , Model model){
		  
			Long id= (Long)(model.asMap().get("id"));
			Artista artista= aservice.findbyId(id);
			opera.setArtista(artista);
			artista.getOpere().add(opera);
			oservice.add(opera);
			aservice.add(artista);
			model.addAttribute(artista);
			model.addAttribute(opera);
			
		

		return "amministratoreOpera";


	}
	
	


}
