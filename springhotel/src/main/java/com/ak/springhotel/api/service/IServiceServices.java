package com.ak.springhotel.api.service;

import com.ak.springhotel.entity.Service;

import java.util.List;

public interface IServiceServices {
	void addService(Service service);
	void removeService(Service service);
	List<Service> listAllServices();
	List<String> listAllNameServices();
	Service getServiceByName(String serviceName);

}
