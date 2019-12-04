package hotel_storage;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.storage.IRoomStorage;
import com.hotel.entity.Rooms;

public class RoomStorage implements IRoomStorage{
	
	private List<Rooms> rooms = new ArrayList<>();

	@Override
	public void addRoom(Rooms room) {
		rooms.add(room);		
	}

	@Override
	public List<Rooms> listAllRoom() {
		return rooms;
	}
}
