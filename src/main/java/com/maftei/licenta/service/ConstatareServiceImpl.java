package com.maftei.licenta.service;

import com.maftei.licenta.domain.Constatare;
import com.maftei.licenta.repository.ConstatareRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.PageRequest;

@Service
@Transactional
public class ConstatareServiceImpl implements ConstatareService {

	@Autowired
    ConstatareRepository constatareRepository;

	public long countAllConstatares() {
        return constatareRepository.count();
    }

	public void deleteConstatare(Constatare constatare) {
        constatareRepository.delete(constatare);
    }

	public Constatare findConstatare(Long id) {
        return constatareRepository.getReferenceById(id);
    }

	public List<Constatare> findAllConstatares() {
        return constatareRepository.findAll();
    }

	public List<Constatare> findConstatareEntries(int firstResult, int maxResults) {
        return constatareRepository.findAll(PageRequest.of(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveConstatare(Constatare constatare) {
        constatareRepository.save(constatare);
    }

	public Constatare updateConstatare(Constatare constatare) {
        return constatareRepository.save(constatare);
    }
}
