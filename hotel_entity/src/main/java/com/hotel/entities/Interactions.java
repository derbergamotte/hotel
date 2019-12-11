package com.hotel.entities;

import java.util.Calendar;
import java.util.List;

public class Interactions {
	private Rooms room;
	private Clients client;
	private List<Services> services;
	private Calendar dateArrival;
	private Calendar dateDeparture;
	
	public Rooms getRoom() {
		return room;
	}
	public void setRoom(Rooms room) {
		this.room = room;
	}
	public Clients getClient() {
		return client;
	}
	public void setClient(Clients client) {
		this.client = client;
	}
	public List<Services> getServices() {
		return services;
	}
	public void setServices(List<Services> services) {
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

	public Interactions(Rooms room, Clients client, List<Services> services, Calendar dateArrival, Calendar dateDeparture) {
		this.room = room;
		this.client = client;
		this.services = services;
		this.dateArrival = dateArrival;
		this.dateDeparture = dateDeparture;

	}
	public Interactions() {
	}
	
}
