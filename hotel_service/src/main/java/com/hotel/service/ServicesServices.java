package com.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.services.IServicesServices;
import com.hotel.api.storage.IServicesDAO;
import com.hotel.entities.Services;
import com.hotel.storages.ServicesDAO;

public class ServicesServices implements IServicesServices {
	IServicesDAO servicesDAO = new ServicesDAO();

	@Override
	public void addService(Services service) {
		servicesDAO.addServices(service);
	}

	@Override
	public List<Services> listAllServices() {
		return servicesDAO.listAllServices();
	}

	@Override
	public List<String> listAllNameServices() {
		return servicesDAO.listAllServices().stream().map(service -> service.getServiceName())
				.collect(Collectors.toList());
	}

	@Override
	public Services getServiceByName(String serviceName) {
		return servicesDAO.listAllServices().stream().filter(service -> service.getServiceName().equals(serviceName))
				.findAny().orElse(null);
	}

}
