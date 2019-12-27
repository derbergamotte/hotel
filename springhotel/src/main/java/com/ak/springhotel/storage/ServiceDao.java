package com.ak.springhotel.storage;

import com.ak.springhotel.api.storage.IServiceDao;
import com.ak.springhotel.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceDao implements IServiceDao{
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