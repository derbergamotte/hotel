package com.ak.springhotel.storage;

import com.ak.springhotel.api.storage.IInteractionDao;
import com.ak.springhotel.entity.Interaction;

import java.util.ArrayList;
import java.util.List;

public class InteractionDao implements IInteractionDao{
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
