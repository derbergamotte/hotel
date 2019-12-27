package com.ak.springhotel.api.storage;

import com.ak.springhotel.entity.Room;

import java.util.List;

public interface IRoomDao {
	void addRoom(Room room);
	void removeRoom(Room room);
	List<Room> listAllRooms();
}
