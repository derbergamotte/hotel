package com.hotel.main;


import com.hotel.api.services.IClientService;
import com.hotel.api.services.IRoomService;
import com.hotel.api.services.IServiceService;
import com.hotel.entity.Clients;
import com.hotel.entity.Rooms;
import com.hotel.entity.Services;
import com.hotel.services.ClientService;
import com.hotel.services.RoomService;
import com.hotel.services.ServiceService;

public class Main {

	public static void main(String[] args) {
		
		IRoomService roomService = new RoomService();
		IClientService clientService = new ClientService();
		IServiceService serviceService = new ServiceService();
		
		roomService.addRoom();
		
		serviceService.addService(new Services("Pool", 20));
		serviceService.addService(new Services("Breakfast", 10));
		serviceService.removeService("Pool");
		
		System.out.println(serviceService.listAllServices());
				
		clientService.addClient(new Clients("Smirnov",  addClientInRoom(roomService, 200), 14));
		roomService.printAllEmptyRoom();
//		clientService.removeClient(removeClientFromRoom(roomService, 200));	
		roomService.printAllEmptyRoom();
		System.out.println(serviceService.getService("Pool"));
		
//		clientService.addServicesForClient(200, serviceService.getService("Pool"));
		System.out.println(clientService.getClientByRoomNumber(200).getClientServises());
		
		
		System.out.println(clientService.listAllClients());
		
	}
	@SuppressWarnings("unused")
	private static Rooms addClientInRoom(IRoomService roomService, int numberOfRoom) {
		roomService.setUnempty(numberOfRoom);
		return roomService.getRoomByNumber(numberOfRoom);
	}
	@SuppressWarnings("unused")
	private static Rooms removeClientFromRoom(IRoomService roomService, int numberOfRoom) {
		roomService.setEmpty(numberOfRoom);
		return roomService.getRoomByNumber(numberOfRoom);
	}


}
