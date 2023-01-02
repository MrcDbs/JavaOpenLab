package it.dipartimenti.entities;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="dipartimento")
@SequenceGenerator(name="seq_gen",sequenceName="new_sequence",initialValue=1,allocationSize=3)
public class Dipartimento {
	private String nome;
	private String citta;
	private Integer id;
	private String indirizzo;
	
	private List<Impiegato> impiegati;
	
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name="citta")
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq_gen")
	 @Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="indirizzo")
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	@OneToMany(mappedBy="dipartimento",cascade = CascadeType.PERSIST)
	public List<Impiegato> getImpiegati() {
		return impiegati;
	}
	public void setImpiegati(List<Impiegato> impiegati) {
		this.impiegati = impiegati;
	}
	
	public String toString() {
		return nome+" "+citta+" "+indirizzo;
	}
	
	public void addImpiegato(Impiegato impiegato) {
		if(impiegato == null)
			 throw new IllegalArgumentException("Product null!");
		if(impiegati == null)
			impiegati = new ArrayList<>();
		impiegati.add(impiegato);
		impiegato.setDipartimento(this);
	}
	
	public void removeImpiegato(Impiegato impiegato) {
		if(impiegato == null)
			 throw new IllegalArgumentException("Product is null!");
		if(impiegati == null)
			 throw new IllegalArgumentException("List is null!");
		impiegati.remove(impiegato);
		impiegato.setDipartimento(null);
	}
}
