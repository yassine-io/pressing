package com.pressing.service.impl;

import com.pressing.dao.ClientDao;
import com.pressing.models.ClientEntity;
import com.pressing.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientRepository;

    @Autowired
    public ClientServiceImpl(ClientDao clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ClientEntity saveClient(ClientEntity client) {
        return clientRepository.save(client);
    }

    @Override
    public List<ClientEntity> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<ClientEntity> getClientById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }
}
