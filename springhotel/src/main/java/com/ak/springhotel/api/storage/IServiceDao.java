package com.ak.springhotel.api.storage;

import com.ak.springhotel.entity.Service;

import java.util.List;

public interface IServiceDao {
	void addService(Service service);
	void removeService(Service service);
	List<Service> listAllServices();

}
