package com.hotel.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.services.IClientsServices;
import com.hotel.api.services.IInteractionsServices;
import com.hotel.api.services.IRoomsServices;
import com.hotel.api.services.IServicesServices;
import com.hotel.entities.Clients;
import com.hotel.entities.Rooms;
import com.hotel.entities.Services;
import com.hotel.service.ClientsServices;
import com.hotel.service.InteractionsServices;
import com.hotel.service.RoomsServices;
import com.hotel.service.ServicesServices;

@SuppressWarnings("unused")
public class Main {
	static IClientsServices clientsServices = new ClientsServices();
	static IRoomsServices roomsServices = new RoomsServices();
	static IServicesServices servicesServices = new ServicesServices();
	static IInteractionsServices interactionsServices = new InteractionsServices();
	
	public static void main(String[] args) {

		roomsServices.addRoom();
		addClients();
		addSevices();
		
		List<Services> services = new ArrayList<>();
		services.add(servicesServices.getServiceByName("Breakfast"));
		
		Calendar dateArrival = new GregorianCalendar(2019, 0, 3);
		Calendar dateDeparture = new GregorianCalendar(2019, 0, 11);
			
		interactionsServices.addInteraction(roomsServices.getRoomByNumber(200), clientsServices.getClientByName("Ivanov"), 
				services, dateArrival, dateDeparture);
		interactionsServices.addInteraction(roomsServices.getRoomByNumber(200), clientsServices.getClientByName("Petrov"), 
				services, dateArrival, dateDeparture);
		services.add(servicesServices.getServiceByName("Pool"));
		interactionsServices.addInteraction(roomsServices.getRoomByNumber(203), clientsServices.getClientByName("Vasechkin"), 
				services, new GregorianCalendar(2019, 5, 9), new GregorianCalendar(2019, 6, 13));
		
		
		System.out.println(getEmptyRoomsByDate(new GregorianCalendar(2019, 0, 1), new GregorianCalendar(2019, 11, 3)));
		System.out.println(getEmptyRoomsByDate(new GregorianCalendar(2019, 0, 3)));
		System.out.println(roomsServices.mapRoomsAndPrice());
		System.out.println(interactionsServices.getPrice(clientsServices.getClientByName("Ivanov")));
		System.out.println(interactionsServices.getPrice(clientsServices.getClientByName("Petrov")));
		printPriceByClient("Vasechkin");
	}
	private static void addClients() {
		clientsServices.addClient(new Clients("Ivanov"));
		clientsServices.addClient(new Clients("Petrov"));
		clientsServices.addClient(new Clients("Vasechkin"));
		clientsServices.addClient(new Clients("Kutasov"));
	}
	private static void addSevices() {
		servicesServices.addService(new Services("Pool", 20));
		servicesServices.addService(new Services("Breakfast", 10));
	}
	private static List<Integer> getEmptyRoomsByDate(Calendar date){
		return interactionsServices.listEmptyRoom(roomsServices.listAllNumberRooms(), date);
	}
	private static List<Integer> getEmptyRoomsByDate(Calendar firstDate, Calendar lastDate){
		return interactionsServices.listEmptyRoom(roomsServices.listAllNumberRooms(), firstDate, lastDate);
	}
	private static void printPriceByClient(String string) {
		System.out.println(interactionsServices.getPrice(clientsServices.getClientByName(string)));
	}
}
