package it.articoli.dto;

public class ArticoloDTO {
	
	private String nome;
	private String descrizione;
	
	public ArticoloDTO() {}
	
	public ArticoloDTO(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
