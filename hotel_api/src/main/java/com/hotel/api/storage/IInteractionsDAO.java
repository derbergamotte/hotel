package com.hotel.api.storage;

import java.util.List;
import com.hotel.entities.Interactions;

public interface IInteractionsDAO {
	void addInteraction(Interactions interaction);
	List<Interactions> listAllInteractions();
}
