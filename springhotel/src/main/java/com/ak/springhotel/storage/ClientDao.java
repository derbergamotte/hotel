package com.ak.springhotel.storage;

import com.ak.springhotel.api.storage.IClientDao;
import com.ak.springhotel.entity.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDao implements IClientDao{
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
