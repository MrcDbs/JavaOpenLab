package it.tris.scacchiera.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="colonna",schema="scacchiera")
@SequenceGenerator(name="colonna_seq",sequenceName="scacchiera.colonna_id_seq",initialValue=1,allocationSize=2)
public class Colonna {

	private Integer id;
	
	private Integer pos00;
	private Integer pos01;
	private Integer pos02;
	private Integer pos10;
	private Integer pos11;
	private Integer pos12;
	private Integer pos20;
	private Integer pos21;
	private Integer pos22;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="colonna_seq")
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="pos_00")
	public Integer getPos00() {
		return pos00;
	}
	public void setPos00(Integer pos00) {
		this.pos00 = pos00;
	}
	@Column(name="pos_01")
	public Integer getPos01() {
		return pos01;
	}
	public void setPos01(Integer pos01) {
		this.pos01 = pos01;
	}
	@Column(name="pos_02")
	public Integer getPos02() {
		return pos02;
	}
	public void setPos02(Integer pos02) {
		this.pos02 = pos02;
	}
	@Column(name="pos_10")
	public Integer getPos10() {
		return pos10;
	}
	public void setPos10(Integer pos10) {
		this.pos10 = pos10;
	}
	@Column(name="pos_11")
	public Integer getPos11() {
		return pos11;
	}
	public void setPos11(Integer pos11) {
		this.pos11 = pos11;
	}
	@Column(name="pos_12")
	public Integer getPos12() {
		return pos12;
	}
	public void setPos12(Integer pos12) {
		this.pos12 = pos12;
	}
	@Column(name="pos_20")
	public Integer getPos20() {
		return pos20;
	}
	public void setPos20(Integer pos20) {
		this.pos20 = pos20;
	}
	@Column(name="pos_21")
	public Integer getPos21() {
		return pos21;
	}
	public void setPos21(Integer pos21) {
		this.pos21 = pos21;
	}
	@Column(name="pos_22")
	public Integer getPos22() {
		return pos22;
	}
	public void setPos22(Integer pos22) {
		this.pos22 = pos22;
	}
	
	
}
