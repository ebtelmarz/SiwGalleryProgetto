package it.uniroma3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.repositories.ArtistaRepository;
import it.uniroma3.model.Artista;

@Service
@ComponentScan(basePackages="it.uniroma3.repositories")
@EntityScan("it.uniroma3.model")
public class ArtistaService {
	@Autowired
	private ArtistaRepository arepository;
	

    public Iterable<Artista> findAll() {
        return this.arepository.findAll();
    }

    @Transactional
    public void add(final Artista artista) {
        this.arepository.save(artista);
    }
    @Transactional
    public void delete(final Artista artista){
    	this.arepository.delete(artista);
    }

	public Artista findbyId(Long id) {
		return this.arepository.findOne(id);
	}
	
	public List<Artista> findByNome(String nome){
		
		return this.arepository.findByNome(nome);
	}
	

}
