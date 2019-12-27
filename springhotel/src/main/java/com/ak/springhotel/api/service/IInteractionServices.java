package com.ak.springhotel.api.service;

import com.ak.springhotel.entity.Client;
import com.ak.springhotel.entity.Interaction;
import com.ak.springhotel.entity.Room;
import com.ak.springhotel.entity.Service;

import java.util.Calendar;
import java.util.List;

public interface IInteractionServices {
	void addInteraction(Room room, Client client, List<Service> services, Calendar dateArrival, Calendar dateDeparture);
	void removeInteraction(Interaction interaction);
	List<Interaction> listAllInteractions();
	List<Interaction> listAllInteractionsByRoom(Integer roomNumber);
	List<Integer> listEmptyRooms(List<Integer> numbersOfRoom, Calendar date);
	List<Integer> listEmptyRooms(List<Integer> numbersOfRoom, Calendar firstDate, Calendar lastDate);
	int getPrice(Client client);
}
