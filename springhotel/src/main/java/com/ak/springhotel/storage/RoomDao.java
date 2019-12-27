package com.ak.springhotel.storage;

import com.ak.springhotel.api.storage.IRoomDao;
import com.ak.springhotel.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomDao implements IRoomDao{
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