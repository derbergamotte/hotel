package com.hotel.entity;

public class Services {
	private String serviceName;
	private int price;
			

	public Services(String serviceName, int price) {
		this.serviceName = serviceName;
		this.price = price;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviseName) {
		this.serviceName = serviseName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
