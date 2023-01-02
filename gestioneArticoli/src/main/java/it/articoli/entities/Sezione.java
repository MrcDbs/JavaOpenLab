package it.articoli.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sezione",schema="articoli")
@SequenceGenerator(name="sez_seq",sequenceName="articoli.sezione_id_seq",initialValue=1,allocationSize=3)
public class Sezione {

	private Integer id;
	private String nome;
	private String descrizione;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sez_seq")
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
	@Column(name="descrizione")
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
