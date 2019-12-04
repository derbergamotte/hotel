package hotel_storage;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.storage.IServiceStorage;
import com.hotel.entity.Services;

public class ServiceStorage implements IServiceStorage {

	private List<Services> services = new ArrayList<>();

	@Override
	public void addService(Services service) {
		services.add(service);
	}

	@Override
	public void removeService(Services service) {
		services.remove(service);
	}

	@Override
	public List<Services> listAllServices() {
		return services;
	}

}
