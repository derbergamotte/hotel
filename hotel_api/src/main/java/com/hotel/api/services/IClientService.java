package com.hotel.api.services;

import java.util.List;
import com.hotel.entity.Clients;
import com.hotel.entity.Rooms;
import com.hotel.entity.Services;

public interface IClientService {
	void addClient(Clients client);

	void removeClient(Rooms room);

	void addServicesForClient(int numberOfRoom, Services service);

	Clients getClientByRoomNumber(int numberOfRoom);

	Clients getClientByRoom(Rooms room);

	List<String> listAllClients();

}
