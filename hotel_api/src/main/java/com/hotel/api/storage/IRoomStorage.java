package com.hotel.api.storage;

import java.util.List;
import com.hotel.entity.Rooms;

public interface IRoomStorage {
	void addRoom(Rooms room);

	List<Rooms> listAllRoom();
}
