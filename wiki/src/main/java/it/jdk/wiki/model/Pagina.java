package it.jdk.wiki.model;

import java.util.Date;

public class Pagina {

	private Integer id;
	private String titolo;
	private String contenuto;
	private Date ultimaModifica;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getContenuto() {
		return contenuto;
	}
	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	public Date getUltimaModifica() {
		return ultimaModifica;
	}
	public void setUltimaModifica(Date ultimaModifica) {
		this.ultimaModifica = ultimaModifica;
	}
	
	
}
