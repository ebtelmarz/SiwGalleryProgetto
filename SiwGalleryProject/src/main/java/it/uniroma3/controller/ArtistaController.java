package it.uniroma3.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.model.Artista;

@Controller
public class ArtistaController {

	@GetMapping("/artistaAggiunta")
	public String mostraForm(Artista artista){
		return "amministratore";
		
	}
	 @PostMapping("/artistaAggiunta")
	    public String checkArtistaInfo(@Valid @ModelAttribute Artista artista, 
	    									BindingResult bindingResult, Model model) {
	    	
	        if (bindingResult.hasErrors()) {
	            return "amministratore";
	        }
	        else {
	        	model.addAttribute(artista);
	            //artistaservice.add(artista); da creare
	        }
	        return "amministratore";
	    }
	 
	 @PostMapping("/artistaRimozione")
	 public String  rimozioneArtista(@ModelAttribute Artista artista){
		 //artistaservice.delete(artista);
		 return "amministratore";
	 }
	    
	

}
