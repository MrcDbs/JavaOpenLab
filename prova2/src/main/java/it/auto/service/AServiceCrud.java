package it.auto.service;

import it.auto.dto.AutoDTO;

public interface AServiceCrud {

	public void creaAuto(AutoDTO autoDto);
	
	public void modifica(AutoDTO autoDto, Integer id);
	
	public void cancellaAuto(Integer id);
}
