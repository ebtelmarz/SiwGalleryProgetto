package it.uniroma3.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping("/opere")
	public String stampaArtisti(Model model){
		model.addAttribute("opere",oservice.findAll());
		return "opere";
	}

	@PostMapping("/aggiuntaOpere")
	public String aggiungiOpera(@Valid@ModelAttribute Opera opera,BindingResult bindingResult,@RequestParam String id, Model model){
		Artista artista= aservice.findbyId(Long.parseLong(id));
		model.addAttribute("artista",artista);
		if(bindingResult.hasErrors()){
			return "amministratoreOpera";
		}
		else{

			opera.setArtista(artista);
			artista.getOpere().add(opera);
			oservice.add(opera);
			aservice.add(artista);
			model.addAttribute("opera",opera);

		}
		return "amministratoreOpera";

	}
	@PostMapping("/aggiuntaOpereDaOption")
	public String aggiungiOperaDaOption(@Valid@ModelAttribute Opera opera,BindingResult bindingResult,@RequestParam String id, Model model){
		model.addAttribute("artisti", aservice.findAll());
		Artista artista= aservice.findbyId(Long.parseLong(id));
		model.addAttribute("artista",artista);
		if(bindingResult.hasErrors()){
			return "aggiungOperaAmmOption";
		}
		else{

			opera.setArtista(artista);
			artista.getOpere().add(opera);
			oservice.add(opera);
			aservice.add(artista);
			model.addAttribute("opera",opera);

		}
	
	return "aggiungOperaAmmOption";

}

@RequestMapping("/aggOpera")
public String vistaAmmArtista(Model model, Opera opera){
	model.addAttribute("artisti", aservice.findAll());
	return "aggiungOperaAmmOption";
}
@RequestMapping("/nuovaOpera/{id}")
public String paginaFormOpera(@PathVariable String id, Model model,Opera opera){
	Artista artista = aservice.findbyId(Long.parseLong(id));
	model.addAttribute("artista",artista);
	return "amministratoreOpera";
}

@PostMapping("/eliminaOpera")
public String eliminaOpera(@RequestParam String id, Model model, @RequestParam String artistaId){
	model.addAttribute("artista", aservice.findbyId(Long.parseLong(artistaId)));
	oservice.delete(oservice.findbyId(Long.parseLong(id)));
	model.addAttribute("opere", oservice.findByArtistaId(Long.parseLong(artistaId)));
	return "resocontoArtista";
}
@RequestMapping("/paginaOpera/{id}")
public String paginaOpera(@PathVariable String id,Model model){
	model.addAttribute("opera", oservice.findbyId(Long.parseLong(id)));
	return "resocontoOpera";
}

}
