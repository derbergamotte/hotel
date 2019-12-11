package com.hotel.storages;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.storage.IClientsDAO;
import com.hotel.entities.Clients;

public class ClientsDAO implements IClientsDAO{
	private List<Clients> clients = new ArrayList<>();
	
	@Override
	public void addClient(Clients client) {
		clients.add(client);		
	}

	@Override
	public List<Clients> listAllClients() {
		return clients;
	}

}
