package com.poli.deserial;

import java.util.Collection;

// @JsonIgnoreProperties(ignoreUnknown = true)
public class Zoo {
	private Collection<Animal> animals;

	public Collection<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(Collection<Animal> animals) {
		this.animals = animals;
	}

}
