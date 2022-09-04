package com.maftei.licenta.service;

import com.maftei.licenta.domain.EchipamentService;
import com.maftei.licenta.repository.EchipamentServiceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EchipamentServiceServiceImpl implements EchipamentServiceService {

	@Autowired
    EchipamentServiceRepository echipamentServiceRepository;

	public long countAllEchipamentServices() {
        return echipamentServiceRepository.count();
    }

	public void deleteEchipamentService(EchipamentService echipamentService) {
        echipamentServiceRepository.delete(echipamentService);
    }

	public EchipamentService findEchipamentService(Long id) {
        return echipamentServiceRepository.getReferenceById(id);
    }

	public List<EchipamentService> findAllEchipamentServices() {
        return echipamentServiceRepository.findAll();
    }

	public List<EchipamentService> findEchipamentServiceEntries(int firstResult, int maxResults) {
        return echipamentServiceRepository.findAll(PageRequest.of(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveEchipamentService(EchipamentService echipamentService) {
        echipamentServiceRepository.save(echipamentService);
    }

	public EchipamentService updateEchipamentService(EchipamentService echipamentService) {
        return echipamentServiceRepository.save(echipamentService);
    }
}
