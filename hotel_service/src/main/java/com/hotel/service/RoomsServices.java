package com.hotel.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.hotel.api.services.IRoomsServices;
import com.hotel.api.storage.IRoomsDAO;
import com.hotel.entities.Rooms;
import com.hotel.storages.RoomsDAO;

public class RoomsServices implements IRoomsServices {
	IRoomsDAO roomsDAO = new RoomsDAO();

	@Override
	public void addRoom() {
		roomsDAO.addRoom(new Rooms(101, 50));
		roomsDAO.addRoom(new Rooms(102, 40));
		roomsDAO.addRoom(new Rooms(103, 45));
		roomsDAO.addRoom(new Rooms(104, 50));
		roomsDAO.addRoom(new Rooms(105, 55));
		roomsDAO.addRoom(new Rooms(200, 99));
		roomsDAO.addRoom(new Rooms(201, 60));
		roomsDAO.addRoom(new Rooms(202, 65));
		roomsDAO.addRoom(new Rooms(203, 75));
		roomsDAO.addRoom(new Rooms(204, 70));
		roomsDAO.addRoom(new Rooms(205, 70));
	}

	@Override
	public void addRoom(Rooms room) {
		roomsDAO.addRoom(room);
	}

	@Override
	public List<Rooms> listAllRooms() {
		return roomsDAO.listAllRooms();
	}

	@Override
	public List<Integer> listAllNumberRooms() {
		return roomsDAO.listAllRooms().stream().map(room -> room.getRoomNumber()).collect(Collectors.toList());
	}

	@Override
	public Rooms getRoomByNumber(Integer roomNumber) {
		return roomsDAO.listAllRooms().stream().filter(room -> room.getRoomNumber().equals(roomNumber)).findAny()
				.orElse(null);
	}

	@Override
	public Map<Integer, Integer> mapRoomsAndPrice() {
		return roomsDAO.listAllRooms().stream().collect(Collectors.toMap(Rooms::getRoomNumber, Rooms::getRoomPrice));
	}

}
