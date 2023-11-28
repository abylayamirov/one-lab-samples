package kz.onelab.onelabsamples.repository;

import kz.onelab.onelabsamples.entity.Client;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository {

    void save(Client client);

    //
    Optional<Client> findByClientName(String name);

}
