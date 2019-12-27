package com.ak.springhotel.service;

import com.ak.springhotel.api.service.IServiceServices;
import com.ak.springhotel.api.storage.IServiceDao;
import com.ak.springhotel.entity.Service;
import com.ak.springhotel.storage.ServiceDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceServices implements IServiceServices {
	private static final Logger logger = LoggerFactory.getLogger(ServiceServices.class);
	IServiceDao serviceDao = new ServiceDao();

	@Override
	public void addService(Service service) {
		if (!serviceDao.listAllServices().contains(service)) {
			serviceDao.addService(service);
		}else {
			logger.info("This service is already exists");
		}
	}

	@Override
	public List<Service> listAllServices() {
		return serviceDao.listAllServices();
	}

	@Override
	public List<String> listAllNameServices() {
		return serviceDao.listAllServices().stream().map(Service::getServiceName)
				.collect(Collectors.toList());
	}

	@Override
	public Service getServiceByName(String serviceName) {
		return serviceDao.listAllServices().stream().filter(service -> service.getServiceName().equals(serviceName))
				.findAny().orElse(null);
	}

	@Override
	public void removeService(Service service) {
		serviceDao.removeService(service);		
	}

}