package com.maftei.licenta.service;

import com.maftei.licenta.domain.Interventie;
import com.maftei.licenta.repository.InterventieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class InterventieServiceImpl implements InterventieService {

	@Autowired
    InterventieRepository interventieRepository;

	public long countAllInterventies() {
        return interventieRepository.count();
    }

	public void deleteInterventie(Interventie interventie) {
        interventieRepository.delete(interventie);
    }

	public Interventie findInterventie(Long id) {
        return interventieRepository.getReferenceById(id);
    }

	public List<Interventie> findAllInterventies() {
        return interventieRepository.findAll();
    }

	public List<Interventie> findInterventieEntries(int firstResult, int maxResults) {
        return interventieRepository.findAll(PageRequest.of(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveInterventie(Interventie interventie) {
        interventieRepository.save(interventie);
    }

	public Interventie updateInterventie(Interventie interventie) {
        return interventieRepository.save(interventie);
    }
}
