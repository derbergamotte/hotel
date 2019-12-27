package com.hotel.storages;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.storage.IRoomDAO;
import com.hotel.entities.Room;

public class RoomDAO implements IRoomDAO{
	private List<Room> rooms = new ArrayList<>();
			
	@Override
	public void addRoom(Room room) {
		rooms.add(room);
	}
	@Override
	public List<Room> listAllRooms() {
		return rooms;
	}
	@Override
	public void removeRoom(Room room) {
		rooms.remove(room);
		
	}

}
