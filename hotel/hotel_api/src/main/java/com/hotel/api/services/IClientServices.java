package com.hotel.api.services;

import java.util.List;
import com.hotel.entities.Client;

public interface IClientServices {
	void addClient(Client client);
	void removeClient(Client client);
	List<Client> listAllClients();
	List<String> listAllNameClients();
	Client getClientByName(String clientName);
}
