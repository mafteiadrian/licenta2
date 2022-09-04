package com.maftei.licenta.service;

import com.maftei.licenta.domain.Client;
import com.maftei.licenta.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
    ClientRepository clientRepository;

	public long countAllClients() {
        return clientRepository.count();
    }

	public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

	public Client findClient(Long id) {
        return clientRepository.getReferenceById(id);
    }

	public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

	public List<Client> findClientEntries(int firstResult, int maxResults) {
        return clientRepository.findAll(PageRequest.of(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveClient(Client client) {
        clientRepository.save(client);
    }

	public Client updateClient(Client client) {
        return clientRepository.save(client);
    }
}
