package com.ak.springhotel.entity;

import java.util.Calendar;
import java.util.List;

public class Interaction {
	private Room room;
	private Client client;
	private List<Service> services;
	private Calendar dateArrival;
	private Calendar dateDeparture;
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	public Calendar getDateArrival() {
		return dateArrival;
	}
	public void setDateArrival(Calendar dateArrival) {
		this.dateArrival = dateArrival;
	}
	public Calendar getDateDeparture() {
		return dateDeparture;
	}
	public void setDateDeparture(Calendar dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	public Interaction(Room room, Client client, List<Service> services, Calendar dateArrival, Calendar dateDeparture) {
		this.room = room;
		this.client = client;
		this.services = services;
		this.dateArrival = dateArrival;
		this.dateDeparture = dateDeparture;

	}
	public Interaction() {
	}
	
}
