package com.maftei.licenta.service;

import com.maftei.licenta.domain.Angajat;
import java.util.List;

public interface AngajatService {

	public abstract long countAllAngajats();


	public abstract void deleteAngajat(Angajat angajat);


	public abstract Angajat findAngajat(Long id);


	public abstract List<Angajat> findAllAngajats();


	public abstract List<Angajat> findAngajatEntries(int firstResult, int maxResults);


	public abstract void saveAngajat(Angajat angajat);


	public abstract Angajat updateAngajat(Angajat angajat);

}
