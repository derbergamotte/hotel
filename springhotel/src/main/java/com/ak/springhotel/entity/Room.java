package com.ak.springhotel.entity;

public class Room {
	private Integer roomNumber;
	private Integer roomPrice;
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Integer getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}
	public Room(Integer roomNumber, Integer roomPrice) {
		this.roomNumber = roomNumber;
		this.roomPrice = roomPrice;
	}
	public Room() {
	}

}