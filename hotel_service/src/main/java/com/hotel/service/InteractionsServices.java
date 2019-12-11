package com.hotel.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.services.IInteractionsServices;
import com.hotel.api.storage.IInteractionsDAO;
import com.hotel.entities.Clients;
import com.hotel.entities.Interactions;
import com.hotel.entities.Rooms;
import com.hotel.entities.Services;
import com.hotel.storages.InteractionsDAO;

public class InteractionsServices implements IInteractionsServices { // Lasciate ogni speranza, voi ch’entrate
	IInteractionsDAO interactionsDAO = new InteractionsDAO();

	@Override
	public void addInteraction(Rooms room, Clients client, List<Services> services, Calendar dateArrival,
			Calendar dateDeparture) {
		if (client != null && room != null) {
			if (!getDaysOfStay(dateArrival, dateDeparture).stream()
					.map(date -> getNumbersOccupiedRooms(date).contains(room.getRoomNumber()))
					.collect(Collectors.toList()).contains(true)) {

				interactionsDAO.addInteraction(new Interactions(room, client, services, dateArrival, dateDeparture));
			} else {
				System.out.println("This room is occupaid");
			}
		} else if (client == null) {
			System.out.println("This client is not exists");
		} else {
			System.out.println("This room is not exists");
		}
	}

	@Override
	public List<Interactions> listAllInteractions() {
		return interactionsDAO.listAllInteractions();
	}

	@Override
	public List<Interactions> listAllInteractionsByRoom(Integer roomNumber) {
		return interactionsDAO.listAllInteractions().stream()
				.filter(interaction -> interaction.getRoom().getRoomNumber().equals(roomNumber))
				.collect(Collectors.toList());
	}

	@Override
	public List<Integer> listEmptyRoom(List<Integer> numbersOfRoom, Calendar date) {
		numbersOfRoom.removeAll(getNumbersOccupiedRooms(date));
		return numbersOfRoom;
	}

	@Override
	public List<Integer> listEmptyRoom(List<Integer> numbersOfRoom, Calendar firstDate, Calendar lastDate) {
		getDaysOfStay(firstDate, lastDate).stream().map(date -> numbersOfRoom.removeAll(getNumbersOccupiedRooms(date)))
				.collect(Collectors.toList());
		return numbersOfRoom;
	}

	@Override
	public int getPrice(Clients client) {
		Interactions clientHistory = new Interactions();
		int price = 0;
		clientHistory = interactionsDAO.listAllInteractions().stream().filter(i -> i.getClient().equals(client))
				.reduce((first, second) -> second).orElse(null);
		if (clientHistory != null) {
			price = (clientHistory.getRoom().getRoomPrice() + clientHistory.getServices().stream()
					.map(service -> service.getServicePrice()).mapToInt(a -> a).sum())
					* getDaysOfStay(clientHistory.getDateArrival(), clientHistory.getDateDeparture()).size();
		}
		return price;
	}

	private List<Integer> getNumbersOccupiedRooms(Calendar date) {
		return interactionsDAO.listAllInteractions().stream()
				.filter(interaction -> getDaysOfStay(interaction.getDateArrival(), interaction.getDateDeparture())
						.contains(date))
				.map(interaction -> interaction.getRoom().getRoomNumber()).collect(Collectors.toList());
	}

	private List<Calendar> getDaysOfStay(Calendar dateArrival, Calendar dateDeparture) {
		Calendar date = new GregorianCalendar();
		date = (Calendar) dateArrival.clone();
		List<Calendar> dates = new ArrayList<>();
		do {
			dates.add((Calendar) date.clone());
			date.add(Calendar.DATE, 1);
		} while (date.compareTo(dateDeparture) < 1);
		return dates;
	}
}
