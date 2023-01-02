package it.carrello.javabean;

import java.util.ArrayList;
import java.util.List;

public class Carrello {

	private double tot;
	private int itemsCount;
	private List<Item> lista;
	
	public Carrello() {
		lista = new ArrayList<Item>();
		tot=0;
		
	}
	
	

	public double getTot() {
		for(Item i:lista) {
			tot+=i.getPrezzo();
		}
		return tot;
	}



	public void setTot(double tot) {
		this.tot = tot;
	}



	public int getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;
	}

	public List<Item> getLista() {
		return lista;
	}

	public void setLista(List<Item> lista) {
		this.lista = lista;
		itemsCount=lista.size();
	}
	
	public void addItem(Item i) {
		if(lista.add(i))
			itemsCount++;
	}
	
	public void removeItem(Item i) {
		if(lista.remove(i))
			itemsCount--;
	}
}
