package it.articoli.dto;

import java.util.List;

public class PageDTO {
	
	private Integer numPage;
	private Integer numOfElement;
	private List<ArticoloDTO> listaDto;
	
	public PageDTO() {}
	
	public PageDTO(Integer numPage, Integer numOfElement, List<ArticoloDTO> listaDto) {
		this.numPage = numPage;
		this.numOfElement = numOfElement;
		this.listaDto = listaDto;
	}
	public Integer getNumPage() {
		return numPage;
	}
	public void setNumPage(Integer numPage) {
		this.numPage = numPage;
	}
	public Integer getNumOfElement() {
		return numOfElement;
	}
	public void setNumOfElement(Integer numOfElement) {
		this.numOfElement = numOfElement;
	}
	public List<ArticoloDTO> getListaDto() {
		return listaDto;
	}
	public void setListaDto(List<ArticoloDTO> listaDto) {
		this.listaDto = listaDto;
	}
	
	
}
