package com.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.services.IClientsServices;
import com.hotel.api.storage.IClientsDAO;
import com.hotel.entities.Clients;
import com.hotel.storages.ClientsDAO;

public class ClientsServices implements IClientsServices {
	IClientsDAO clientsDAO = new ClientsDAO();

	@Override
	public void addClient(Clients client) {
		clientsDAO.addClient(client);
	}

	@Override
	public List<Clients> listAllClients() {
		return clientsDAO.listAllClients();
	}

	@Override
	public List<String> listAllNameClients() {
		return clientsDAO.listAllClients().stream().map(client -> client.getClientName()).collect(Collectors.toList());
	}

	@Override
	public Clients getClientByName(String clientName) {
		return clientsDAO.listAllClients().stream().filter(client -> client.getClientName().equals(clientName))
				.reduce((first, second) -> second).orElse(null);
	}

}
