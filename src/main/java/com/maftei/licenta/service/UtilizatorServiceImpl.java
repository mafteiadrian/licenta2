package com.maftei.licenta.service;

import com.maftei.licenta.domain.Utilizator;
import com.maftei.licenta.repository.UtilizatorRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UtilizatorServiceImpl implements UtilizatorService {

	@Autowired
    UtilizatorRepository utilizatorRepository;

	public long countAllUtilizators() {
        return utilizatorRepository.count();
    }

	public void deleteUtilizator(Utilizator utilizator) {
        utilizatorRepository.delete(utilizator);
    }

	public Utilizator findUtilizator(Long id) {
        return utilizatorRepository.getReferenceById(id);
    }

	public List<Utilizator> findAllUtilizators() {
        return utilizatorRepository.findAll();
    }

	public List<Utilizator> findUtilizatorEntries(int firstResult, int maxResults) {
        return utilizatorRepository.findAll(PageRequest.of(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveUtilizator(Utilizator utilizator) {
        utilizatorRepository.save(utilizator);
    }

	public Utilizator updateUtilizator(Utilizator utilizator) {
        return utilizatorRepository.save(utilizator);
    }

	@Override
	public Utilizator findByUsername(String numeUtilizator) {
		List<Utilizator> lisUtilizators = findAllUtilizators();
		for(Utilizator u : lisUtilizators){
			if(u.getNumeUtilizator().equals(numeUtilizator)){
				return u;
			}
		}
		return null;
	}
}
