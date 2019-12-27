package com.hotel.api.storage;

import java.util.List;
import com.hotel.entities.Interaction;

public interface IInteractionDAO {
	void addInteraction(Interaction interaction);
	void removeInteraction(Interaction interaction);
	List<Interaction> listAllInteractions();
}
