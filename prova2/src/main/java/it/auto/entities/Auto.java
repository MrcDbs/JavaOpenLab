package it.auto.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="auto",schema="prova2")
@SequenceGenerator(name="auto_seq",sequenceName="prova2.auto_id_seq",initialValue=1,allocationSize=3)
public class Auto {
	
	private Integer id;
	private String targa;
	private Date dataProduzione;
	private String modello;
	private Double costo;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="auto_seq")
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="targa")
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	@Column(name="data_produzione")
	public Date getDataProduzione() {
		return dataProduzione;
	}
	public void setDataProduzione(Date dataProduzione) {
		this.dataProduzione = dataProduzione;
	}
	@Column(name="modello")
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	@Column(name="costo")
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	

}
