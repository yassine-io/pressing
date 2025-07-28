package com.pressing.service;

import com.pressing.models.ArticleEntity;
import com.pressing.models.ClientEntity;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    ClientEntity saveClient(ClientEntity client);

    List<ClientEntity> getAllClient();

    Optional<ClientEntity> getClientById(Integer id);

    void deleteClient(Integer id);


}
