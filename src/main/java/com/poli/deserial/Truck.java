package com.poli.deserial;

import static java.util.Objects.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Truck implements Vehicle {
	String name;

	@JsonCreator
	public Truck(@JsonProperty("name") final String name) {
		this.name = requireNonNull(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
