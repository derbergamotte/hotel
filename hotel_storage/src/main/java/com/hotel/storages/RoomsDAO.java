package com.hotel.storages;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.storage.IRoomsDAO;
import com.hotel.entities.Rooms;

public class RoomsDAO implements IRoomsDAO{
	private List<Rooms> rooms = new ArrayList<>();
			
	@Override
	public void addRoom(Rooms room) {
		rooms.add(room);
	}
	@Override
	public List<Rooms> listAllRooms() {
		return rooms;
	}

}
