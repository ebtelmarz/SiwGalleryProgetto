package it.uniroma3.repositories;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long> {
    public Opera findByTitolo(String nome);
    
    
    
}
