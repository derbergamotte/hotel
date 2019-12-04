package com.hotel.entity;

import java.util.ArrayList;
import java.util.List;

public class Clients {
	private String clientName;
	private Rooms clientRoom;
	private List<Services> clientServises = new ArrayList<>(); 
	private int clientDate;
	
	
	public Clients(String clientName, Rooms clientRoom,	int clientDate) {
		this.clientName = clientName;
		this.clientRoom = clientRoom;
		this.clientDate = clientDate;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Rooms getClientRoom() {
		return clientRoom;
	}
	public void setClientRoom(Rooms clientRoom) {
		this.clientRoom = clientRoom;
	}
	public List<Services> getClientServises() {
		return clientServises;
	}
	public void setClientServises(List<Services> clientServises) {
		this.clientServises = clientServises;
	}
	public int getClientDate() {
		return clientDate;
	}
	public void setClientDate(int clientDate) {
		this.clientDate = clientDate;
	}

}
