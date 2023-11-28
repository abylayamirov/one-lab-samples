package kz.onelab.onelabsamples.service;

import kz.onelab.onelabsamples.db.ClientDb;
import kz.onelab.onelabsamples.entity.Client;
import kz.onelab.onelabsamples.exception.ClientNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    // repository -> (LibraryDb)

    public void addClient(Client client) {
        ClientDb.clients.add(client);
    }

    public Client getClientByName(String name) {
        return ClientDb.clients.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ClientNotFoundException("Client with name: %s not found".formatted(name)));
    }

    public void deleteClientByName(String name) {
        Client clientByName = this.getClientByName(name);
        ClientDb.clients.remove(clientByName);
    }

}
