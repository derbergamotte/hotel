package com.hotel.api.storage;

import java.util.List;
import com.hotel.entities.Services;

public interface IServicesDAO {
	void addServices(Services service);
	List<Services> listAllServices();

}
