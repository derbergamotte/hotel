package com.hotel.services;

import java.util.List;
import java.util.stream.Collectors;
import com.hotel.api.services.IRoomService;
import com.hotel.api.storage.IRoomStorage;
import com.hotel.entity.Rooms;
import hotel_storage.RoomStorage;

public class RoomService implements IRoomService {

	IRoomStorage roomStorage = new RoomStorage();

	@Override
	public void addRoom() {
		roomStorage.addRoom(new Rooms(101, 50));
		roomStorage.addRoom(new Rooms(102, 40));
		roomStorage.addRoom(new Rooms(103, 45));
		roomStorage.addRoom(new Rooms(104, 50));
		roomStorage.addRoom(new Rooms(105, 55));
		roomStorage.addRoom(new Rooms(200, 100));
		roomStorage.addRoom(new Rooms(201, 60));
		roomStorage.addRoom(new Rooms(202, 65));
		roomStorage.addRoom(new Rooms(203, 75));
		roomStorage.addRoom(new Rooms(204, 70));
		roomStorage.addRoom(new Rooms(205, 70));
	}

	@Override
	public void setUnempty(int numberOfRoom) {
		getRoomByNumber(numberOfRoom).setIsEmpty(false);

	}

	@Override
	public void setEmpty(int numberOfRoom) {
		getRoomByNumber(numberOfRoom).setIsEmpty(true);

	}

	@Override
	public List<Integer> listAllRoom() {
		return roomStorage.listAllRoom().stream().map(room -> room.getRoom()).collect(Collectors.toList());
	}

	@Override
	public List<Integer> listAllEmptyRoom() {
		return roomStorage.listAllRoom().stream().filter(room -> room.getIsEmpty()).map(room -> room.getRoom())
				.collect(Collectors.toList());
	}

	@Override
	public Rooms getRoomByNumber(int numberOfRoom) {
		return roomStorage.listAllRoom().get(roomStorage.listAllRoom().stream().map(room -> room.getRoom())
				.collect(Collectors.toList()).indexOf(numberOfRoom));
	}

	@Override
	public void printAllRoom() {
		System.out.println(listAllRoom());
	}

	@Override
	public void printAllEmptyRoom() {
		System.out.println(listAllEmptyRoom());
	}
}
