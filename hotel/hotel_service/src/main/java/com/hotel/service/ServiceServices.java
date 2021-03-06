package com.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotel.api.services.IServiceServices;
import com.hotel.api.storage.IServiceDAO;
import com.hotel.entities.Service;
import com.hotel.storages.ServiceDAO;

public class ServiceServices implements IServiceServices {
	private static final Logger logger = LoggerFactory.getLogger(ServiceServices.class);
	IServiceDAO serviceDAO = new ServiceDAO();

	@Override
	public void addService(Service service) {
		if (!serviceDAO.listAllServices().contains(service)) {
			serviceDAO.addService(service);
		}else {
			logger.info("This service is already exists");
		}
	}

	@Override
	public List<Service> listAllServices() {
		return serviceDAO.listAllServices();
	}

	@Override
	public List<String> listAllNameServices() {
		return serviceDAO.listAllServices().stream().map(Service::getServiceName)
				.collect(Collectors.toList());
	}

	@Override
	public Service getServiceByName(String serviceName) {
		return serviceDAO.listAllServices().stream().filter(service -> service.getServiceName().equals(serviceName))
				.findAny().orElse(null);
	}

	@Override
	public void removeService(Service service) {
		serviceDAO.removeService(service);		
	}

}
