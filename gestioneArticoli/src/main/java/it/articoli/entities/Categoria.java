package it.articoli.entities;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import it.articoli.composite.CategoriaNome;

@Entity
@Table(name="categoria",schema="articoli")
public class Categoria {

	private CategoriaNome nome;
	private String descrizione;
	
	private Sezione sezione;
	
	@EmbeddedId
	public CategoriaNome getNome() {
		return nome;
	}
	public void setNome(CategoriaNome nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="sezione")
	public Sezione getSezione() {
		return sezione;
	}
	public void setSezione(Sezione sezione) {
		this.sezione = sezione;
	}
	
	
	
	
}
