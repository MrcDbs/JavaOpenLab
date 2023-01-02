package it.dipartimenti.dto;

public class ImpiegatoDTO {

	private String nome;
	private String cognome;
	private String codiceFiscale;
	private Integer numeroUfficio;
	private String dipartimento;
	
	public ImpiegatoDTO() {}
	
	public ImpiegatoDTO(String nome,String cognome, String codiceFiscale,Integer numeroUfficio,String dipartimento) {
		this.nome=nome;
		this.cognome=cognome;
		this.codiceFiscale=codiceFiscale;
		this.numeroUfficio=numeroUfficio;
		this.dipartimento=dipartimento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}

	public Integer getNumeroUfficio() {
		return numeroUfficio;
	}

	public void setNumeroUfficio(Integer numeroUfficio) {
		this.numeroUfficio = numeroUfficio;
	}
	
	
	
}
