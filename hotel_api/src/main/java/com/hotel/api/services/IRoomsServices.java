package com.hotel.api.services;

import java.util.List;
import java.util.Map;
import com.hotel.entities.Rooms;

public interface IRoomsServices {
	void addRoom();

	void addRoom(Rooms room);

	List<Rooms> listAllRooms();

	List<Integer> listAllNumberRooms();

	Rooms getRoomByNumber(Integer roomNumber);

	Map<Integer, Integer> mapRoomsAndPrice();
}
