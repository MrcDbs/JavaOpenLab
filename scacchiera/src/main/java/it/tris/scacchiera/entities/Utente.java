package it.tris.scacchiera.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="utente",schema="scacchiera")
@SequenceGenerator(name="utente_seq",sequenceName="scacchiera.utente_id_seq",initialValue=1,allocationSize=3)
public class Utente {
	
	private Integer id;
	private String nome;
	private String cognome;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="utente_seq")
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name="cognome")
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
}
