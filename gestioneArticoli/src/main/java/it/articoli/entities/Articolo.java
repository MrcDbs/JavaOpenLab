package it.articoli.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="articolo",schema="articoli")
@SequenceGenerator(name="art_seq",sequenceName="articoli.articolo_id_seq",initialValue=1,allocationSize=3)
public class Articolo {
	
	private Integer id;
	private String titolo;
	private String descrizione;
	
	private Categoria categoria;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="art_seq")
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="titolo")
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	@Column(name="descrizione")
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="categoria")
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
