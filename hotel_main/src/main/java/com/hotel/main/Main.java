package com.hotel.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.services.IClientServices;
import com.hotel.api.services.IInteractionServices;
import com.hotel.api.services.IRoomServices;
import com.hotel.api.services.IServiceServices;
import com.hotel.entities.Client;
import com.hotel.entities.Room;
import com.hotel.entities.Service;
import com.hotel.facade.Hotel;
import com.hotel.service.ClientServices;
import com.hotel.service.InteractionServices;
import com.hotel.service.RoomServices;
import com.hotel.service.ServiceServices;

@SuppressWarnings("unused")
public class Main {
	static Hotel hotel = new Hotel();
	
	public static void main(String[] args) {
	
		hotel.addRoom();
		addClients();
		addSevices();
		
		List<Service> services = new ArrayList<>();
		services.add(hotel.getServiceByName("Breakfast"));
		
		Calendar dateArrival = new GregorianCalendar(2019, 0, 3);
		Calendar dateDeparture = new GregorianCalendar(2019, 0, 11);
			
		hotel.addInteraction(200, "Ivanov", services, dateArrival, dateDeparture);
		hotel.addInteraction(200, "Petrov",	services, dateArrival, dateDeparture);
		services.add(hotel.getServiceByName("Pool"));
		hotel.addInteraction(203, "Vasechkin", services, new GregorianCalendar(2019, 5, 9), new GregorianCalendar(2019, 6, 13));
		
		
		System.out.println(hotel.getEmptyRoomsByDates(new GregorianCalendar(2019, 0, 1), new GregorianCalendar(2019, 11, 3)));
		System.out.println(hotel.getEmptyRoomsByDate(new GregorianCalendar(2019, 0, 3)));
		System.out.println(hotel.mapRoomsAndPrice());
		System.out.println(hotel.getPrice(hotel.getClientByName("Ivanov")));
		System.out.println(hotel.getPrice(hotel.getClientByName("Petrov")));
		hotel.printPriceByClient("Vasechkin");
	}
	private static void addClients() {
		hotel.addClient(new Client("Ivanov"));
		hotel.addClient(new Client("Petrov"));
		hotel.addClient(new Client("Vasechkin"));
		hotel.addClient(new Client("Kutasov"));
	}
	private static void addSevices() {
		hotel.addService(new Service("Pool", 20));
		hotel.addService(new Service("Breakfast", 10));
	}

}
