package com.hotel.api.services;

import java.util.Calendar;
import java.util.List;

import com.hotel.entities.Client;
import com.hotel.entities.Interaction;
import com.hotel.entities.Room;
import com.hotel.entities.Service;

public interface IInteractionServices {
	void addInteraction(Room room, Client client, List<Service> services, Calendar dateArrival, Calendar dateDeparture);
	void removeInteraction(Interaction interaction);
	List<Interaction> listAllInteractions();
	List<Interaction> listAllInteractionsByRoom(Integer roomNumber);
	List<Integer> listEmptyRooms(List<Integer> numbersOfRoom, Calendar date);
	List<Integer> listEmptyRooms(List<Integer> numbersOfRoom, Calendar firstDate, Calendar lastDate);
	int getPrice(Client client);
}
