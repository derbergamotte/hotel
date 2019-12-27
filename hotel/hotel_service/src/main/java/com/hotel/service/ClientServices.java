package com.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotel.api.services.IClientServices;
import com.hotel.api.storage.IClientDAO;
import com.hotel.entities.Client;
import com.hotel.storages.ClientDAO;

public class ClientServices implements IClientServices {
	private static final Logger logger = LoggerFactory.getLogger(ClientServices.class);
	IClientDAO clientDAO = new ClientDAO();
	
	@Override
	public void addClient(Client client) {
		if (!clientDAO.listAllClients().contains(client)) {
			clientDAO.addClient(client);
		} else {
			logger.info("This client is already exists");
		}
	}

	@Override
	public List<Client> listAllClients() {
		return clientDAO.listAllClients();
	}

	@Override
	public List<String> listAllNameClients() {
		return clientDAO.listAllClients().stream().map(Client::getClientName).collect(Collectors.toList());
	}

	@Override
	public Client getClientByName(String clientName) {
		return clientDAO.listAllClients().stream().filter(client -> client.getClientName().equals(clientName))
				.reduce((first, second) -> second).orElse(null);
	}

	@Override
	public void removeClient(Client client) {
		if (clientDAO.listAllClients().contains(client)) {
			clientDAO.removeClient(client);
		} else {
			logger.info("This client isn't exists");
		}
		
	}

}
