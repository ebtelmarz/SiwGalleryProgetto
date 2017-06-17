package it.uniroma3.model;



import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Artista {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min=1)
	private String nome;
	@NotNull
	@Size(min=1)
	private String cognome;
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	@Temporal(TemporalType.DATE)
	private Date dataMorte;
	@OneToMany(mappedBy="artista", cascade={CascadeType.REMOVE , CascadeType.PERSIST})
	private List<Opera> opere;

	public Artista(){}
	public Artista(String nome,String cognome, Date d1, Date d2 ){
		this.nome=nome;
		this.cognome=cognome;
		this.dataNascita=d1;
		this.dataMorte=d2;
	}

	public List<Opera> getOpere() {
		return opere;
	}
	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}
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

	public Date getDataMorte() {
		return dataMorte;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataMorte == null) ? 0 : dataMorte.hashCode());
		result = prime * result + ((dataNascita == null) ? 0 : dataNascita.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((opere == null) ? 0 : opere.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataMorte == null) {
			if (other.dataMorte != null)
				return false;
		} else if (!dataMorte.equals(other.dataMorte))
			return false;
		if (dataNascita == null) {
			if (other.dataNascita != null)
				return false;
		} else if (!dataNascita.equals(other.dataNascita))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (opere == null) {
			if (other.opere != null)
				return false;
		} else if (!opere.equals(other.opere))
			return false;
		return true;
	}

}
