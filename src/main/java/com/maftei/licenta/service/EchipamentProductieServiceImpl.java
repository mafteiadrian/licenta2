package com.maftei.licenta.service;

import com.maftei.licenta.domain.EchipamentProductie;
import com.maftei.licenta.repository.EchipamentProductieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EchipamentProductieServiceImpl implements EchipamentProductieService {

	@Autowired
    EchipamentProductieRepository echipamentProductieRepository;

	public long countAllEchipamentProducties() {
        return echipamentProductieRepository.count();
    }

	public void deleteEchipamentProductie(EchipamentProductie echipamentProductie) {
        echipamentProductieRepository.delete(echipamentProductie);
    }

	public EchipamentProductie findEchipamentProductie(Long id) {
        return echipamentProductieRepository.getReferenceById(id);
    }

	public List<EchipamentProductie> findAllEchipamentProducties() {
        return echipamentProductieRepository.findAll();
    }

	public List<EchipamentProductie> findEchipamentProductieEntries(int firstResult, int maxResults) {
        return echipamentProductieRepository.findAll(PageRequest.of(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveEchipamentProductie(EchipamentProductie echipamentProductie) {
        echipamentProductieRepository.save(echipamentProductie);
    }

	public EchipamentProductie updateEchipamentProductie(EchipamentProductie echipamentProductie) {
        return echipamentProductieRepository.save(echipamentProductie);
    }
}
