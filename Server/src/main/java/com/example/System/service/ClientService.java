package com.example.System.service;

import com.example.System.entity.Client;
import com.example.System.exception.UserNotFoundException;
import com.example.System.model.ModelClient;
import com.example.System.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){this.clientRepository = clientRepository;}

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> comparison(Client client) {
        return clientRepository.comparison(client);
    }

    public List<ModelClient> findAllClient(){
        return clientRepository.findAll().stream().map(ModelClient::toModel).collect(Collectors.toList());
    }

    public ModelClient getOneClient(String login, String password) throws UserNotFoundException {
        Client client = clientRepository.findOne(login, password);
        if (client == null) {
            throw new UserNotFoundException("Клиент не найден.");
        }
        return ModelClient.toModel(client);
    }

    public Client updateClient(Client client) { return clientRepository.update(client); }

    public Long deleteClient(Long id) {
        clientRepository.deleteById(id);
        return id;
    }
}
