package it.uniroma3.model;

import javax.persistence.*;

@Entity
public class Opera {
	@Override
	public String toString() {
		return "Opera [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", dimensione=" + dimensione
				+ ", tecnica=" + tecnica + ", anno=" + anno + ", artista=" + artista + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anno == null) ? 0 : anno.hashCode());
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((dimensione == null) ? 0 : dimensione.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tecnica == null) ? 0 : tecnica.hashCode());
		result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
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
		Opera other = (Opera) obj;
		if (anno == null) {
			if (other.anno != null)
				return false;
		} else if (!anno.equals(other.anno))
			return false;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (dimensione == null) {
			if (other.dimensione != null)
				return false;
		} else if (!dimensione.equals(other.dimensione))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tecnica == null) {
			if (other.tecnica != null)
				return false;
		} else if (!tecnica.equals(other.tecnica))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String titolo;
	private String descrizione;
	private String dimensione;
	private String tecnica;
	private String anno;
	@ManyToOne
	private Artista artista;
	public Opera(){}
	public Opera(String titolo, String descr , String dimensione, String tecnica ,String anno, Artista artista){
		this.anno=anno;
		this.titolo=titolo;
		this.descrizione=descr;
		this.dimensione=dimensione;
		this.tecnica=tecnica;
		this.artista=artista;
	}
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDimensione() {
		return dimensione;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
