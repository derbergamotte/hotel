package com.hotel.api.storage;

import java.util.List;
import com.hotel.entities.Room;

public interface IRoomDAO {
	void addRoom(Room room);
	void removeRoom(Room room);
	List<Room> listAllRooms();
}
