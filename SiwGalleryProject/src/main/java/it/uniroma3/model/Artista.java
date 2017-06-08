package it.uniroma3.model;



import java.util.Date;

import javax.persistence.*;

public class Artista {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   private String nome;
   private Date dataNascita;
   private Date dataMorte;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Date getDataNascita() {
	return dataNascita;
}
public void setDataNascita(Date dataNascita) {
	this.dataNascita = dataNascita;
}
public Date getDataMorte() {
	return dataMorte;
}
public void setDataMorte(Date dataMorte) {
	this.dataMorte = dataMorte;
}
}
