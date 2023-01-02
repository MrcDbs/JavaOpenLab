package it.articoli.dto;

public class ArticoloFiltroDTO {

	private Integer numPage;
	private Integer numOfElements;
	private String filter;
	
	
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
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	
}
