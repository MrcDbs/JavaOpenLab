package it.auto.dto;

import java.util.List;

public class PageDTO {

	private Integer numPage;
	private Integer numOfElements;
	private List<AutoDTO> listaAuto;
	
	
	public Integer getNumPage() {
		return numPage;
	}
	public void setNumPage(Integer numPage) {
		this.numPage = numPage;
	}
	public Integer getNumOfElements() {
		return numOfElements;
	}
	public void setNumOfElements(Integer numOfElements) {
		this.numOfElements = numOfElements;
	}
	public List<AutoDTO> getListaAuto() {
		return listaAuto;
	}
	public void setListaAuto(List<AutoDTO> listaAuto) {
		this.listaAuto = listaAuto;
	}
	
	
}
