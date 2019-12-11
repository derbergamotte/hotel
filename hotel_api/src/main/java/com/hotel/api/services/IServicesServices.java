package com.hotel.api.services;

import java.util.List;
import com.hotel.entities.Services;

public interface IServicesServices {
	void addService(Services service);
	List<Services> listAllServices();
	List<String> listAllNameServices();
	Services getServiceByName(String serviceName);

}
