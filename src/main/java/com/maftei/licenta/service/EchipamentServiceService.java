package com.maftei.licenta.service;

import com.maftei.licenta.domain.EchipamentService;
import java.util.List;

public interface EchipamentServiceService {

	public abstract long countAllEchipamentServices();


	public abstract void deleteEchipamentService(EchipamentService echipamentService);


	public abstract EchipamentService findEchipamentService(Long id);


	public abstract List<EchipamentService> findAllEchipamentServices();


	public abstract List<EchipamentService> findEchipamentServiceEntries(int firstResult, int maxResults);


	public abstract void saveEchipamentService(EchipamentService echipamentService);


	public abstract EchipamentService updateEchipamentService(EchipamentService echipamentService);

}
