package com.maftei.licenta.service;

import com.maftei.licenta.domain.Constatare;
import java.util.List;

public interface ConstatareService {

	public abstract long countAllConstatares();


	public abstract void deleteConstatare(Constatare constatare);


	public abstract Constatare findConstatare(Long id);


	public abstract List<Constatare> findAllConstatares();


	public abstract List<Constatare> findConstatareEntries(int firstResult, int maxResults);


	public abstract void saveConstatare(Constatare constatare);


	public abstract Constatare updateConstatare(Constatare constatare);

}
