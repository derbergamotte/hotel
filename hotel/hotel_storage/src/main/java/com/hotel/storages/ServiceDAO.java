package com.hotel.storages;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.storage.IServiceDAO;
import com.hotel.entities.Service;

public class ServiceDAO implements IServiceDAO{
	List<Service> services = new ArrayList<>();

	@Override
	public void addService(Service service) {
		services.add(service);
	}

	@Override
	public List<Service> listAllServices() {
		return services;
	}

	@Override
	public void removeService(Service service) {
		services.remove(service);		
	}

}
