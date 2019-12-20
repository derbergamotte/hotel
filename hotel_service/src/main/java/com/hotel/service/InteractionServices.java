package com.hotel.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotel.api.services.IInteractionServices;
import com.hotel.api.storage.IInteractionDAO;
import com.hotel.entities.Client;
import com.hotel.entities.Interaction;
import com.hotel.entities.Room;
import com.hotel.entities.Service;
import com.hotel.storages.InteractionDAO;

public class InteractionServices implements IInteractionServices { // Lasciate ogni speranza, voi ch’entrate
	private static final Logger logger = LoggerFactory.getLogger(InteractionServices.class);
	IInteractionDAO interactionDAO = new InteractionDAO();

	@Override
	public void addInteraction(Room room, Client client, List<Service> services, Calendar dateArrival,
			Calendar dateDeparture) {
		if (client != null && room != null) {
			if (!getDaysOfStay(dateArrival, dateDeparture).stream()
					.map(date -> getNumbersOccupiedRooms(date).contains(room.getRoomNumber()))
					.collect(Collectors.toList()).contains(true)) {

				interactionDAO.addInteraction(new Interaction(room, client, services, dateArrival, dateDeparture));
			} else {
				logger.info("This room is occupaid by this date");
			}
		} else if (client == null) {
			logger.info("This client isn't exists");
		} else {
			logger.info("This room isn't exists");
		}
	}


	@Override
	public void removeInteraction(Interaction interaction) {
		interactionDAO.removeInteraction(interaction);
	}
	
	@Override
	public List<Interaction> listAllInteractions() {
		return interactionDAO.listAllInteractions();
	}

	@Override
	public List<Interaction> listAllInteractionsByRoom(Integer roomNumber) {
		return interactionDAO.listAllInteractions().stream()
				.filter(interaction -> interaction.getRoom().getRoomNumber().equals(roomNumber))
				.collect(Collectors.toList());
	}

	@Override
	public List<Integer> listEmptyRooms(List<Integer> numbersOfRoom, Calendar date) {
		numbersOfRoom.removeAll(getNumbersOccupiedRooms(date));
		return numbersOfRoom;
	}

	@Override
	public List<Integer> listEmptyRooms(List<Integer> numbersOfRoom, Calendar firstDate, Calendar lastDate) {
		getDaysOfStay(firstDate, lastDate).stream().map(date -> numbersOfRoom.removeAll(getNumbersOccupiedRooms(date)))
				.collect(Collectors.toList());
		return numbersOfRoom;
	}

	@Override
	public int getPrice(Client client) {
		Interaction clientHistory;
		int price = 0;
		clientHistory = interactionDAO.listAllInteractions().stream().filter(i -> i.getClient().equals(client))
				.reduce((first, second) -> second).orElse(null);
		if (clientHistory != null) {
			price = (clientHistory.getRoom().getRoomPrice() + clientHistory.getServices().stream()
					.map(Service::getServicePrice).mapToInt(a -> a).sum())
					* getDaysOfStay(clientHistory.getDateArrival(), clientHistory.getDateDeparture()).size();
		}
		return price;
	}

	private List<Integer> getNumbersOccupiedRooms(Calendar date) {
		return interactionDAO.listAllInteractions().stream()
				.filter(interaction -> getDaysOfStay(interaction.getDateArrival(), interaction.getDateDeparture())
						.contains(date))
				.map(interaction -> interaction.getRoom().getRoomNumber()).collect(Collectors.toList());
	}

	private List<Calendar> getDaysOfStay(Calendar dateArrival, Calendar dateDeparture) {
		Calendar date;
		date = (Calendar) dateArrival.clone();
		List<Calendar> dates = new ArrayList<>();
		do {
			dates.add((Calendar) date.clone());
			date.add(Calendar.DATE, 1);
		} while (date.compareTo(dateDeparture) < 1);
		return dates;
	}

}
