package com.hotel.storages;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.storage.IServicesDAO;
import com.hotel.entities.Services;

public class ServicesDAO implements IServicesDAO{
	List<Services> services = new ArrayList<>();

	@Override
	public void addServices(Services service) {
		services.add(service);
	}

	@Override
	public List<Services> listAllServices() {
		return services;
	}

}
