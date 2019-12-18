package com.hotel.entities;

public class Service {
	private String serviceName;
	private int servicePrice;
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public int getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(int servicePrice) {
		this.servicePrice = servicePrice;
	}
	public Service(String serviceName, int servicePrice) {
		this.serviceName = serviceName;
		this.servicePrice = servicePrice;
	}
	public Service() {
	}

}
