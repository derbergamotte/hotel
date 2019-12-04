package com.hotel.entity;

public class Rooms {
	private int room;
	private int price;
	private boolean isEmpty;
	
	public Rooms(int room, int price, boolean isEmpty) {
		super();
		this.room = room;
		this.price = price;
		this.isEmpty = isEmpty;
	}
	
	public Rooms(int room, int price) {
		super();
		this.room = room;
		this.price = price;
		this.isEmpty = true;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean getIsEmpty() {
		return isEmpty;
	}
	public void setIsEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}


}
