package com.ak.springhotel.api.service;

import com.ak.springhotel.entity.Client;

import java.util.List;

public interface IClientServices {
	void addClient(Client client);
	void removeClient(Client client);
	List<Client> listAllClients();
	List<String> listAllNameClients();
	Client getClientByName(String clientName);
}
