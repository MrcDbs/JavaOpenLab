package it.tris.scacchiera.dto;

public class PartitaDTO {

	private String giocatore1;
	private String giocatore2;
	private Integer idPartita;
	
	public PartitaDTO() {}
	
	public PartitaDTO(String giocatore1, String giocatore2, Integer idPartita) {
		super();
		this.giocatore1 = giocatore1;
		this.giocatore2 = giocatore2;
		this.idPartita = idPartita;
	}
	public String getGiocatore1() {
		return giocatore1;
	}
	public void setGiocatore1(String giocatore1) {
		this.giocatore1 = giocatore1;
	}
	public String getGiocatore2() {
		return giocatore2;
	}
	public void setGiocatore2(String giocatore2) {
		this.giocatore2 = giocatore2;
	}
	public Integer getIdPartita() {
		return idPartita;
	}
	public void setIdPartita(Integer idPartita) {
		this.idPartita = idPartita;
	}
	
	
}
