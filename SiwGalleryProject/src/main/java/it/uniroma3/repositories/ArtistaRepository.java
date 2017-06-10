package it.uniroma3.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Artista;

public interface ArtistaRepository extends CrudRepository<Artista, Long> {
     public List<Artista> findByNome(String nome);
     public List<Artista> findByDataNascita(Date data);
     public List<Artista> findByDataMorte(Date data);
}
