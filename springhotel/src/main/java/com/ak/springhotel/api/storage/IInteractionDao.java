package com.ak.springhotel.api.storage;

import com.ak.springhotel.entity.Interaction;

import java.util.List;

public interface IInteractionDao {
	void addInteraction(Interaction interaction);
	void removeInteraction(Interaction interaction);
	List<Interaction> listAllInteractions();
}