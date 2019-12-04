package com.hotel.api.storage;

import java.util.List;
import com.hotel.entity.Services;

public interface IServiceStorage {
	void addService(Services service);

	void removeService(Services service);

	List<Services> listAllServices();
}
