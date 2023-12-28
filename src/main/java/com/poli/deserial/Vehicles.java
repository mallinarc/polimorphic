package com.poli.deserial;

import static java.util.Objects.requireNonNull;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicles {
	List<Vehicle> vehicles;

	@JsonCreator
	public Vehicles(@JsonProperty("vehicles") final List<Vehicle> vehicles) {
		super();
		this.vehicles = requireNonNull(vehicles);
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
