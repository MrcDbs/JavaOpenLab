package it.dipartimenti.dto;

public class DipartimentoDTO {

	private String nome;
	private String citta;
	private String indirizzo;
	
	public DipartimentoDTO() {}
	
	public DipartimentoDTO(String nome,String citta,String indirizzo) {
		this.nome=nome;
		this.citta=citta;
		this.indirizzo=indirizzo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
}
