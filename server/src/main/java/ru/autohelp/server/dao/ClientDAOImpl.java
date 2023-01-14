package ru.autohelp.server.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.autohelp.server.models.Client;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Client> getAllClients() {
        Query query = (Query) entityManager.createQuery("FROM Client ");
        List<Client> allClients = query.getResultList();
        return allClients;
    }

    @Override
    public void saveClient(Client client) {
        Client newClient = entityManager.merge(client);
        client.setId(newClient.getId());
    }

    @Override
    public Client getClient(int id) {
        Client client = entityManager.find(Client.class, id);
        return client;
    }

    @Override
    public void deleteClient(int id) {
        Query query = (Query) entityManager.createQuery("DELETE FROM Client where id =: clientId");
        query.setParameter("clientId", id);
        query.executeUpdate();
    }
}
