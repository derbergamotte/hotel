package com.hotel.api.storage;

import java.util.List;
import com.hotel.entities.Client;

public interface IClientDAO {
	void addClient(Client client);
	void removeClient(Client client);
	List<Client> listAllClients();

}
