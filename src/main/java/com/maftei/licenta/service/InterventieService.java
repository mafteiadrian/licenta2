package com.maftei.licenta.service;

import com.maftei.licenta.domain.Interventie;
import java.util.List;

public interface InterventieService {

	public abstract long countAllInterventies();


	public abstract void deleteInterventie(Interventie interventie);


	public abstract Interventie findInterventie(Long id);


	public abstract List<Interventie> findAllInterventies();


	public abstract List<Interventie> findInterventieEntries(int firstResult, int maxResults);


	public abstract void saveInterventie(Interventie interventie);


	public abstract Interventie updateInterventie(Interventie interventie);

}
