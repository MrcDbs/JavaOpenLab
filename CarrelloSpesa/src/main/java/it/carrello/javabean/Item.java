package it.carrello.javabean;

public class Item {

	private long id;
	private double prezzo;
	private String descrizione;
	
	public Item() {}
	
	public Item(long id, double prezzo, String descrizione) {
		this.id = id;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String toString() {
		return "Item numero "+id+" - Prezzo : "+prezzo+" - Descrizione : "+descrizione;
	}
	
}
