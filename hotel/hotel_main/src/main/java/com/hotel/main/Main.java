package com.hotel.main;

import com.hotel.entities.Client;
import com.hotel.entities.Service;
import com.hotel.facade.Hotel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
	private static final String VASECHKIN = "Vasechkin";
	private static final String PETROV = "Petrov";
	private static final String IVANOV = "Ivanov";
	private static Hotel hotel = new Hotel();

	public static void main(String[] args) {

		hotel.addRoom();
		addClients();
		addSevices();

		List<Service> services = new ArrayList<>();
		services.add(hotel.getServiceByName("Breakfast"));

		Calendar dateArrival = new GregorianCalendar(2019, 0, 3);
		Calendar dateDeparture = new GregorianCalendar(2019, 0, 11);

		hotel.addInteraction(200, IVANOV, services, dateArrival, dateDeparture);
		hotel.addInteraction(200, PETROV, services, dateArrival, dateDeparture);
		services.add(hotel.getServiceByName("Pool"));
		hotel.addInteraction(203, VASECHKIN, services, new GregorianCalendar(2019, 5, 9),
				new GregorianCalendar(2019, 6, 13));

		hotel.printListEmptyRooms(new GregorianCalendar(2019, 0, 1), new GregorianCalendar(2019, 11, 3));
		hotel.printListEmptyRooms(new GregorianCalendar(2019, 0, 3));
		hotel.printRoomsAndPrice();
		hotel.printPriceByClient(IVANOV);
		hotel.printPriceByClient(PETROV);
		hotel.printPriceByClient(VASECHKIN);
	}

	private static void addClients() {
		hotel.addClient(new Client(IVANOV));
		hotel.addClient(new Client(PETROV));
		hotel.addClient(new Client(VASECHKIN));
		hotel.addClient(new Client("Kutasov"));
	}

	private static void addSevices() {
		hotel.addService(new Service("Pool", 20));
		hotel.addService(new Service("Breakfast", 10));
	}

}
