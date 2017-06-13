package it.uniroma3.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.repositories.OperaRepository;
import it.uniroma3.model.Artista;
import it.uniroma3.model.Opera;

@Service
@ComponentScan(basePackages="it.uniroma3.repositories")
public class OperaService {
	@Autowired
	private OperaRepository orepository;
	
	public Iterable<Opera> findAll() {
        return this.orepository.findAll();
    }

    @Transactional
    public void add(final Opera opera) {
        this.orepository.save(opera);
    }
    @Transactional
    public void delete(final Opera opera){
    	this.orepository.delete(opera);
    }

	public Opera findbyId(Long id) {
		return this.orepository.findOne(id);
	}

	public ArrayList<Opera> findByArtistaId(Long id) {
		ArrayList<Opera> opereArtista=new ArrayList<Opera>();
		for (Opera opera: this.orepository.findAll()){
			if(opera.getArtista().getId().equals(id))
				opereArtista.add(opera);
	
				
		}
		
		   
		return opereArtista;
	}
	

}
