package ru.autohelp.server2.dao;

import ru.autohelp.server2.entity.Client;

import java.util.List;

public interface ClientDAO {

    public List<Client> getAllClients();
    public void saveClient(Client client);
    public Client getClient(int id);
    public void deleteClient(int id);
}
