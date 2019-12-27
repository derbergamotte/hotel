package com.ak.springhotel.service;

import com.ak.springhotel.api.service.IClientServices;
import com.ak.springhotel.api.storage.IClientDao;
import com.ak.springhotel.entity.Client;
import com.ak.springhotel.storage.ClientDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ClientServices implements IClientServices {
	private static final Logger logger = LoggerFactory.getLogger(ClientServices.class);
	IClientDao clientDao = new ClientDao();
	
	@Override
	public void addClient(Client client) {
		if (!clientDao.listAllClients().contains(client)) {
			clientDao.addClient(client);
		} else {
			logger.info("This client is already exists");
		}
	}

	@Override
	public List<Client> listAllClients() {
		return clientDao.listAllClients();
	}

	@Override
	public List<String> listAllNameClients() {
		return clientDao.listAllClients().stream().map(Client::getClientName).collect(Collectors.toList());
	}

	@Override
	public Client getClientByName(String clientName) {
		return clientDao.listAllClients().stream().filter(client -> client.getClientName().equals(clientName))
				.reduce((first, second) -> second).orElse(null);
	}

	@Override
	public void removeClient(Client client) {
		if (clientDao.listAllClients().contains(client)) {
			clientDao.removeClient(client);
		} else {
			logger.info("This client isn't exists");
		}
		
	}

}
