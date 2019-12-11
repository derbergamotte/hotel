package com.hotel.api.services;

import java.util.Calendar;
import java.util.List;

import com.hotel.entities.Clients;
import com.hotel.entities.Interactions;
import com.hotel.entities.Rooms;
import com.hotel.entities.Services;

public interface IInteractionsServices {
	void addInteraction(Rooms room, Clients client, List<Services> services, Calendar dateArrival, Calendar dateDeparture);
	List<Interactions> listAllInteractions();
	List<Interactions> listAllInteractionsByRoom(Integer roomNumber);
	List<Integer> listEmptyRoom(List<Integer> numbersOfRoom, Calendar date);
	List<Integer> listEmptyRoom(List<Integer> numbersOfRoom, Calendar firstDate, Calendar lastDate);
	int getPrice(Clients client);
}
