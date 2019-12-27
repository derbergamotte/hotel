package com.hotel.api.storage;

import java.util.List;
import com.hotel.entities.Service;

public interface IServiceDAO {
	void addService(Service service);
	void removeService(Service service);
	List<Service> listAllServices();

}
