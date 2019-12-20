package com.hotel.facade;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotel.api.services.IClientServices;
import com.hotel.api.services.IInteractionServices;
import com.hotel.api.services.IRoomServices;
import com.hotel.api.services.IServiceServices;
import com.hotel.entities.Client;
import com.hotel.entities.Interaction;
import com.hotel.entities.Room;
import com.hotel.entities.Service;
import com.hotel.service.ClientServices;
import com.hotel.service.InteractionServices;
import com.hotel.service.RoomServices;
import com.hotel.service.ServiceServices;

public class Hotel {
	private static final Logger logger = LoggerFactory.getLogger(Hotel.class);
	IClientServices clientService = new ClientServices();
	IRoomServices roomService = new RoomServices();
	IServiceServices serviceService = new ServiceServices();
	IInteractionServices interactionService = new InteractionServices();

	public void addClient(Client client) {
		clientService.addClient(client);
	}

	public void removeClient(Client client) {
		clientService.removeClient(client);
	}

	public List<Client> listAllClients() {
		return clientService.listAllClients();
	}

	public List<String> listAllNameClients() {
		return clientService.listAllNameClients();
	}

	public Client getClientByName(String clientName) {
		return clientService.getClientByName(clientName);
	}

	public void addInteraction(Integer roomNumber, String clientName, List<Service> services, Calendar dateArrival,
			Calendar dateDeparture) {
		interactionService.addInteraction(roomService.getRoomByNumber(roomNumber),
				clientService.getClientByName(clientName), services, dateArrival, dateDeparture);
	}

	public void removeInteraction(Interaction interaction) {
		interactionService.removeInteraction(interaction);
	}

	public List<Interaction> listAllInteractions() {
		return interactionService.listAllInteractions();
	}

	public List<Interaction> listAllInteractionsByRoom(Integer roomNumber) {
		return interactionService.listAllInteractionsByRoom(roomNumber);
	}

	public List<Integer> listEmptyRooms(List<Integer> numbersOfRoom, Calendar date) {
		return interactionService.listEmptyRooms(numbersOfRoom, date);
	}

	public List<Integer> listEmptyRooms(List<Integer> numbersOfRoom, Calendar firstDate, Calendar lastDate) {
		return interactionService.listEmptyRooms(numbersOfRoom, firstDate, lastDate);
	}

	public int getPrice(Client client) {
		return interactionService.getPrice(client);
	}

	public void addRoom() {
		roomService.addRoom();
	}

	public void addRoom(Room room) {
		roomService.addRoom(room);
	}

	public void removeRoom(Room room) {
		roomService.removeRoom(room);
	}

	public List<Room> listAllRooms() {
		return roomService.listAllRooms();
	}

	public List<Integer> listAllNumberRooms() {
		return roomService.listAllNumberRooms();
	}

	public Room getRoomByNumber(Integer roomNumber) {
		return roomService.getRoomByNumber(roomNumber);
	}

	public Map<Integer, Integer> mapRoomsAndPrice() {
		return roomService.mapRoomsAndPrice();
	}

	public void addService(Service service) {
		serviceService.addService(service);
	}

	public void removeService(Service service) {
		serviceService.removeService(service);
	}

	public List<Service> listAllServices() {
		return serviceService.listAllServices();
	}

	public List<String> listAllNameServices() {
		return serviceService.listAllNameServices();
	}

	public Service getServiceByName(String serviceName) {
		return serviceService.getServiceByName(serviceName);
	}

	public List<Integer> getEmptyRoomsByDate(Calendar date) {
		return interactionService.listEmptyRooms(roomService.listAllNumberRooms(), date);
	}

	public List<Integer> getEmptyRoomsByDates(Calendar firstDate, Calendar lastDate) {
		return interactionService.listEmptyRooms(roomService.listAllNumberRooms(), firstDate, lastDate);
	}

	public void printPriceByClient(String string) {
		String priceLogger = String.format("Price by %s is %s", string, interactionService.getPrice(clientService.getClientByName(string)));
		logger.info(priceLogger);
	}
	public void printListEmptyRooms(Calendar date) {
		String emptyRooms = interactionService.listEmptyRooms(roomService.listAllNumberRooms(), date).toString();
		logger.info(emptyRooms);
	}
	public void printListEmptyRooms(Calendar firstDate, Calendar lastDate) {
		String emptyRooms =  interactionService.listEmptyRooms(roomService.listAllNumberRooms(), firstDate, lastDate).toString();
		logger.info(emptyRooms);
	}
	public void printRoomsAndPrice() {
		String roomsAndPrice = roomService.mapRoomsAndPrice().toString();
		logger.info(roomsAndPrice);
	}
}
