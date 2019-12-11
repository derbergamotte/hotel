package com.hotel.storages;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.storage.IInteractionsDAO;
import com.hotel.entities.Interactions;

public class InteractionsDAO implements IInteractionsDAO{
	private List<Interactions> interactions = new ArrayList<>();
	
	@Override
	public void addInteraction(Interactions interaction) {
		interactions.add(interaction);		
	}

	@Override
	public List<Interactions> listAllInteractions() {
		return interactions;
	}

}
