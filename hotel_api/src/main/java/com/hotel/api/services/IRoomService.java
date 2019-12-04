package com.hotel.api.services;

import java.util.List;
import com.hotel.entity.Rooms;

public interface IRoomService {
	void addRoom();

	void setUnempty(int numberOfRoom);

	void setEmpty(int numberOfRoom);

	Rooms getRoomByNumber(int numberOfRoom);

	List<Integer> listAllRoom();

	List<Integer> listAllEmptyRoom();

	void printAllRoom();

	void printAllEmptyRoom();

}
