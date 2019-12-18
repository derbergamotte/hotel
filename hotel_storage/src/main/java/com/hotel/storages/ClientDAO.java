package com.hotel.storages;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.storage.IClientDAO;
import com.hotel.entities.Client;

public class ClientDAO implements IClientDAO{
	private List<Client> clients = new ArrayList<>();
	
	@Override
	public void addClient(Client client) {
		clients.add(client);		
	}

	@Override
	public List<Client> listAllClients() {
		return clients;
	}

	@Override
	public void removeClient(Client client) {
		clients.remove(client);
	}

}
