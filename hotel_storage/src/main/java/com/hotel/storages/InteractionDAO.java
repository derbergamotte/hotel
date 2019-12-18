package com.hotel.storages;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.storage.IInteractionDAO;
import com.hotel.entities.Interaction;

public class InteractionDAO implements IInteractionDAO{
	private List<Interaction> interactions = new ArrayList<>();
	
	@Override
	public void addInteraction(Interaction interaction) {
		interactions.add(interaction);		
	}

	@Override
	public List<Interaction> listAllInteractions() {
		return interactions;
	}

	@Override
	public void removeInteraction(Interaction interaction) {
		interactions.remove(interaction);
	}

}
