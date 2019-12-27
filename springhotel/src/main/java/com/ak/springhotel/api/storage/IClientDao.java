package com.ak.springhotel.api.storage;

import com.ak.springhotel.entity.Client;

import java.util.List;

public interface IClientDao {
	void addClient(Client client);
	void removeClient(Client client);
	List<Client> listAllClients();

}