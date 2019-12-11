package com.hotel.api.storage;

import java.util.List;
import com.hotel.entities.Clients;

public interface IClientsDAO {
	void addClient(Clients client);
	List<Clients> listAllClients();

}
