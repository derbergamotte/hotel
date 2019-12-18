package com.hotel.api.services;

import java.util.List;
import java.util.Map;
import com.hotel.entities.Room;

public interface IRoomServices {
	void addRoom();
	void addRoom(Room room);
	void removeRoom(Room room);
	List<Room> listAllRooms();
	List<Integer> listAllNumberRooms();
	Room getRoomByNumber(Integer roomNumber);
	Map<Integer, Integer> mapRoomsAndPrice();
}
