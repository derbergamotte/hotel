package com.ak.springhotel.service;

import com.ak.springhotel.api.service.IRoomServices;
import com.ak.springhotel.api.storage.IRoomDao;
import com.ak.springhotel.entity.Room;
import com.ak.springhotel.storage.RoomDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoomServices implements IRoomServices {
	private static final Logger logger = LoggerFactory.getLogger(RoomServices.class);
	IRoomDao roomDao = new RoomDao();

	@Override
	public void addRoom() {
		roomDao.addRoom(new Room(101, 50));
		roomDao.addRoom(new Room(102, 40));
		roomDao.addRoom(new Room(103, 45));
		roomDao.addRoom(new Room(104, 50));
		roomDao.addRoom(new Room(105, 55));
		roomDao.addRoom(new Room(200, 99));
		roomDao.addRoom(new Room(201, 60));
		roomDao.addRoom(new Room(202, 65));
		roomDao.addRoom(new Room(203, 75));
		roomDao.addRoom(new Room(204, 70));
		roomDao.addRoom(new Room(205, 70));
	}

	@Override
	public void addRoom(Room room) {
		if (!roomDao.listAllRooms().contains(room)) {
			roomDao.addRoom(room);
		} else {
			logger.info("This room is already exists");
		}
	}

	@Override
	public List<Room> listAllRooms() {
		return roomDao.listAllRooms();
	}

	@Override
	public List<Integer> listAllNumberRooms() {
		return roomDao.listAllRooms().stream().map(Room::getRoomNumber).collect(Collectors.toList());
	}

	@Override
	public Room getRoomByNumber(Integer roomNumber) {
		return roomDao.listAllRooms().stream().filter(room -> room.getRoomNumber().equals(roomNumber)).findAny()
				.orElse(null);
	}

	@Override
	public Map<Integer, Integer> mapRoomsAndPrice() {
		return roomDao.listAllRooms().stream().collect(Collectors.toMap(Room::getRoomNumber, Room::getRoomPrice));
	}

	@Override
	public void removeRoom(Room room) {
		if (roomDao.listAllRooms().contains(room)) {
			roomDao.removeRoom(room);	
		} else {
			logger.info("This room isn't exists");
		}
	
	}

}
