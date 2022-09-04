package com.maftei.licenta.service;

import com.maftei.licenta.domain.Utilizator;
import java.util.List;

public interface UtilizatorService {

	public abstract long countAllUtilizators();


	public abstract void deleteUtilizator(Utilizator utilizator);


	public abstract Utilizator findUtilizator(Long id);


	public abstract List<Utilizator> findAllUtilizators();


	public abstract List<Utilizator> findUtilizatorEntries(int firstResult, int maxResults);


	public abstract void saveUtilizator(Utilizator utilizator);


	public abstract Utilizator updateUtilizator(Utilizator utilizator);
	
	public abstract Utilizator findByUsername(String numeUtilizator);

}
