package com.hotel.api.services;

import java.util.List;
import com.hotel.entity.Services;

public interface IServiceService {
	
	void addService(Services service);

	void removeService(String string);

	Services getService(String string);

	List<String> listAllServices();

}
