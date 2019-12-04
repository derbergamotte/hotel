package com.hotel.api.storage;

import java.util.List;
import com.hotel.entity.Clients;

public interface IClientStorage {
	void addClient(Clients client);

	void remove(Clients client);

	List<Clients> listAllClients();

}
