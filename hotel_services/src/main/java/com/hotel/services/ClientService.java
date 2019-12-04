package com.hotel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.hotel.api.services.IClientService;
import com.hotel.api.storage.IClientStorage;
import com.hotel.entity.Clients;
import com.hotel.entity.Rooms;
import com.hotel.entity.Services;
import hotel_storage.ClientStorage;


public class ClientService implements IClientService{
	
	IClientStorage clientStorage = new ClientStorage();
	
	@Override
	public void addClient(Clients client) {
		clientStorage.addClient(client);
	}
	@Override
	public void removeClient(Rooms room) {
		clientStorage.remove(getClientByRoom(room));

	}
	@Override
	public void addServicesForClient(int numberOfRoom, Services service) {
		List<Services> a = new ArrayList<>();
		a.add(service);
		getClientByRoomNumber(numberOfRoom).setClientServises(a);
		
	}
	@Override
	public Clients getClientByRoomNumber(int numberOfRoom) {
		return clientStorage.listAllClients().stream().filter(client -> client.getClientRoom().getRoom()==numberOfRoom)
													  .collect(Collectors.toList()).get(0);
	}
	@Override
	public List<String> listAllClients() {
		return clientStorage.listAllClients().stream().map(client -> client.getClientName()).collect(Collectors.toList());
	}
	@Override
	public Clients getClientByRoom(Rooms room) {
		return clientStorage.listAllClients().stream().filter(client -> client.getClientRoom().equals(room))
				 									  .collect(Collectors.toList()).get(0);
	}
}
