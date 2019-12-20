package com.hotel.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotel.api.services.IRoomServices;
import com.hotel.api.storage.IRoomDAO;
import com.hotel.entities.Room;
import com.hotel.storages.RoomDAO;

public class RoomServices implements IRoomServices {
	private static final Logger logger = LoggerFactory.getLogger(RoomServices.class);
	IRoomDAO roomDAO = new RoomDAO();

	@Override
	public void addRoom() {
		roomDAO.addRoom(new Room(101, 50));
		roomDAO.addRoom(new Room(102, 40));
		roomDAO.addRoom(new Room(103, 45));
		roomDAO.addRoom(new Room(104, 50));
		roomDAO.addRoom(new Room(105, 55));
		roomDAO.addRoom(new Room(200, 99));
		roomDAO.addRoom(new Room(201, 60));
		roomDAO.addRoom(new Room(202, 65));
		roomDAO.addRoom(new Room(203, 75));
		roomDAO.addRoom(new Room(204, 70));
		roomDAO.addRoom(new Room(205, 70));
	}

	@Override
	public void addRoom(Room room) {
		if (!roomDAO.listAllRooms().contains(room)) {
			roomDAO.addRoom(room);
		} else {
			logger.info("This room is already exists");
		}
	}

	@Override
	public List<Room> listAllRooms() {
		return roomDAO.listAllRooms();
	}

	@Override
	public List<Integer> listAllNumberRooms() {
		return roomDAO.listAllRooms().stream().map(Room::getRoomNumber).collect(Collectors.toList());
	}

	@Override
	public Room getRoomByNumber(Integer roomNumber) {
		return roomDAO.listAllRooms().stream().filter(room -> room.getRoomNumber().equals(roomNumber)).findAny()
				.orElse(null);
	}

	@Override
	public Map<Integer, Integer> mapRoomsAndPrice() {
		return roomDAO.listAllRooms().stream().collect(Collectors.toMap(Room::getRoomNumber, Room::getRoomPrice));
	}

	@Override
	public void removeRoom(Room room) {
		if (roomDAO.listAllRooms().contains(room)) {
			roomDAO.removeRoom(room);	
		} else {
			logger.info("This room isn't exists");
		}
	
	}

}
