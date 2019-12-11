package com.hotel.api.services;

import java.util.List;
import com.hotel.entities.Clients;

public interface IClientsServices {
	void addClient(Clients client);
	List<Clients> listAllClients();
	List<String> listAllNameClients();
	Clients getClientByName(String clientName);

}
