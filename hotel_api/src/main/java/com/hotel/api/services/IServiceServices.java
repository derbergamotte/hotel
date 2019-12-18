package com.hotel.api.services;

import java.util.List;
import com.hotel.entities.Service;

public interface IServiceServices {
	void addService(Service service);
	void removeService(Service service);
	List<Service> listAllServices();
	List<String> listAllNameServices();
	Service getServiceByName(String serviceName);

}
