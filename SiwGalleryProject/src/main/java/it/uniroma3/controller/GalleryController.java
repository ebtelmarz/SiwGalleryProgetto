package it.uniroma3.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GalleryController {
	

	
@RequestMapping("/artisti")
	public String stampaArtisti(){
		return "artisti";
	}

}
