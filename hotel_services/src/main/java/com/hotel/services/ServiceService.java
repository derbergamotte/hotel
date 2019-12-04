package com.hotel.services;

import java.util.List;
import java.util.stream.Collectors;
import com.hotel.api.services.IServiceService;
import com.hotel.api.storage.IServiceStorage;
import com.hotel.entity.Services;
import hotel_storage.ServiceStorage;

public class ServiceService implements IServiceService {
	IServiceStorage serviceStorage = new ServiceStorage();

	@Override
	public void addService(Services service) {
		serviceStorage.addService(service);
	}

	@Override
	public void removeService(String string) {
		serviceStorage.removeService(serviceStorage.listAllServices().stream()
				.filter(service -> service.getServiceName().equals(string)).collect(Collectors.toList()).get(0));
	}

	@Override
	public Services getService(String string) {
		return serviceStorage.listAllServices().stream().filter(service -> service.getServiceName().equals(string))
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public List<String> listAllServices() {
		return serviceStorage.listAllServices().stream().map(service -> service.getServiceName())
				.collect(Collectors.toList());
	}

}
