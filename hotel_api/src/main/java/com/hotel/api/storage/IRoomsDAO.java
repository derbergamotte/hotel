package com.hotel.api.storage;

import java.util.List;
import com.hotel.entities.Rooms;

public interface IRoomsDAO {
	void addRoom(Rooms room);
	List<Rooms> listAllRooms();
}
