package it.dipartimenti.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="impiegato")
@SequenceGenerator(name="seq_gen",sequenceName="new_sequence",initialValue=1,allocationSize=3)
public class Impiegato {
	
	private Integer id;
	private String nome;
	private String cognome;
	private String citta;
	private Integer numeroUfficio;
	private Integer stipendioAnnuale;
	private String codiceFiscale;
	
	private Dipartimento dipartimento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq_gen")
	 @Column(name = "id")
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
	@Column(name="citta")
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	@Column(name="numero_ufficio")
	public Integer getNumeroUfficio() {
		return numeroUfficio;
	}
	public void setNumeroUfficio(Integer numeroUfficio) {
		this.numeroUfficio = numeroUfficio;
	}
	@Column(name="stipendio_annuale")
	public Integer getStipendioAnnuale() {
		return stipendioAnnuale;
	}
	public void setStipendioAnnuale(Integer stipendioAnnuale) {
		this.stipendioAnnuale = stipendioAnnuale;
	}
	@Column(name="codice_fiscale")
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	@ManyToOne
	@JoinColumn(name="dipartimento_fk")
	public Dipartimento getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
	
	
	
	
	
}
