package com.ak.springhotel.entity;

public class Client {
	private String clientName;

	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Client(String clientName) {
		this.clientName = clientName;
	}
	public Client() {
	}
}
