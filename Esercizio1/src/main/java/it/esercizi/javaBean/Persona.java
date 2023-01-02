package it.esercizi.javaBean;

import java.util.Date;

public class Persona {
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String città;
	private Date dataDiNascita;
	private String username;
	private String password;
	private char genere;
	private String[] newsletterList;
	
	public Persona() {}
		
	public Persona(String nome, String cognome, String codiceFiscale, String città, Date dataDiNascita, String username,
			String password, char genere, String[] newsletter) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.città = città;
		this.dataDiNascita = dataDiNascita;
		this.username = username;
		this.password = password;
		this.genere = genere;
		this.newsletterList = newsletter;
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
	public String getCittà() {
		return città;
	}
	public void setCittà(String città) {
		this.città = città;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getGenere() {
		return genere;
	}
	public void setGenere(char genere) {
		this.genere = genere;
	}
	public String[] getNewsletterList() {
		return newsletterList;
	}
	public void setNewsletterList(String[] newsletter) {
		this.newsletterList = newsletter;
	}
	
	public String getNewsLetter(int index) {
		return newsletterList[index];
	}
}
