package com.ak.springhotel.api.service;

import com.ak.springhotel.entity.Room;

import java.util.List;
import java.util.Map;

public interface IRoomServices {
	void addRoom();
	void addRoom(Room room);
	void removeRoom(Room room);
	List<Room> listAllRooms();
	List<Integer> listAllNumberRooms();
	Room getRoomByNumber(Integer roomNumber);
	Map<Integer, Integer> mapRoomsAndPrice();
}

