package it.auto.dto;

import java.util.Date;

public class AutoDTO {

	private String targa;
	private String modello;
	private Date dataProduzione;

	private Double costo;
	
	public AutoDTO() {}
	
	
	public AutoDTO(String targa, String modello, Date dataProduzione, Double costo) {
		this.targa = targa;
		this.modello = modello;
		this.dataProduzione=dataProduzione;
		this.costo = costo;
	}


	public Date getDataProduzione() {
		return dataProduzione;
	}
	public void setDataProduzione(Date dataProduzione) {
		this.dataProduzione = dataProduzione;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	
}
