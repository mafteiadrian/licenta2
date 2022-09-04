package com.maftei.licenta.service;

import com.maftei.licenta.domain.Angajat;
import com.maftei.licenta.repository.AngajatRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AngajatServiceImpl implements AngajatService {

	@Autowired
    AngajatRepository angajatRepository;

	public long countAllAngajats() {
        return angajatRepository.count();
    }

	public void deleteAngajat(Angajat angajat) {
        angajatRepository.delete(angajat);
    }

	public Angajat findAngajat(Long id) {
        return angajatRepository.getReferenceById(id);
    }

	public List<Angajat> findAllAngajats() {
        return angajatRepository.findAll();
    }

	public List<Angajat> findAngajatEntries(int firstResult, int maxResults) {
        return angajatRepository.findAll(PageRequest.of(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveAngajat(Angajat angajat) {
        angajatRepository.save(angajat);
    }

	public Angajat updateAngajat(Angajat angajat) {
        return angajatRepository.save(angajat);
    }
}
