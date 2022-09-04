package com.maftei.licenta.service;

import com.maftei.licenta.domain.EchipamentProductie;
import java.util.List;

public interface EchipamentProductieService {

	public abstract long countAllEchipamentProducties();


	public abstract void deleteEchipamentProductie(EchipamentProductie echipamentProductie);


	public abstract EchipamentProductie findEchipamentProductie(Long id);


	public abstract List<EchipamentProductie> findAllEchipamentProducties();


	public abstract List<EchipamentProductie> findEchipamentProductieEntries(int firstResult, int maxResults);


	public abstract void saveEchipamentProductie(EchipamentProductie echipamentProductie);


	public abstract EchipamentProductie updateEchipamentProductie(EchipamentProductie echipamentProductie);

}
