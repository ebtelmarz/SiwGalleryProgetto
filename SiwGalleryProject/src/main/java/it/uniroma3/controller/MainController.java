package it.uniroma3.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.model.Artista;
import it.uniroma3.model.Opera;
import it.uniroma3.repositories.ArtistaRepository;
import it.uniroma3.services.ArtistaService;

@Controller
@ComponentScan(basePackages="it.uniroma3.security")

public class MainController {

	// Login form
	@RequestMapping("/loginAmministratore")
	public String login() {
		return "loginAmministratore";
	}


	// Login form with error
	@RequestMapping("/login-error.html")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "loginAmministratore";
	}
	
/*	@RequestMapping("/paginaAmministratore")
	public String paginaAmm(){
		return "amministratore";
	}*/

  /* //index
	@RequestMapping("/index")
	public String  paginaPrincipale(){
		return "index";
	}*/


}
