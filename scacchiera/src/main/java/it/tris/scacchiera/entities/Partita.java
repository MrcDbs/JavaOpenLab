package it.tris.scacchiera.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="partita",schema="scacchiera")
@SequenceGenerator(name="partita_seq",sequenceName="scacchiera.partita_id_seq",initialValue=1,allocationSize=2)
public class Partita {

	private Integer id;
	private Date dataPartita;
	private Utente giocatore1;
	private Utente giocatore2;
	private String simboloGiocatore1;
	private String simboloGiocatore2;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="partita_seq")
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="data_partita")
	public Date getDataPartita() {
		return dataPartita;
	}
	public void setDataPartita(Date dataPartita) {
		this.dataPartita = dataPartita;
	}
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="giocatore_1")
	public Utente getGiocatore1() {
		return giocatore1;
	}
	public void setGiocatore1(Utente giocatore1) {
		this.giocatore1 = giocatore1;
	}
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="giocatore_2")
	public Utente getGiocatore2() {
		return giocatore2;
	}
	public void setGiocatore2(Utente giocatore2) {
		this.giocatore2 = giocatore2;
	}
	@Column(name="simbolo_giocatore_1")
	public String getSimboloGiocatore1() {
		return simboloGiocatore1;
	}
	public void setSimboloGiocatore1(String simboloGiocatore1) {
		this.simboloGiocatore1 = simboloGiocatore1;
	}
	@Column(name="simbolo_giocatore_2")
	public String getSimboloGiocatore2() {
		return simboloGiocatore2;
	}
	public void setSimboloGiocatore2(String simboloGiocatore2) {
		this.simboloGiocatore2 = simboloGiocatore2;
	}
	
	
}
