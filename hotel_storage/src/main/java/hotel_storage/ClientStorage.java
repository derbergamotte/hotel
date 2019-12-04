package hotel_storage;

import java.util.ArrayList;
import java.util.List;
import com.hotel.api.storage.IClientStorage;
import com.hotel.entity.Clients;

public class ClientStorage implements IClientStorage{
	
	private List<Clients> clients = new ArrayList<>();

	@Override
	public void addClient(Clients client) {
		clients.add(client);
	}
	@Override
	public void remove(Clients client) {
		clients.remove(client);
	}
	@Override
	public List<Clients> listAllClients() {
		return clients;
	}

}
