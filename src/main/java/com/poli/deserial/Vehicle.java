package com.poli.deserial;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = NAME, include = PROPERTY)
@JsonSubTypes({ @JsonSubTypes.Type(value = Truck.class, name = "Truck"), @JsonSubTypes.Type(value = Car.class, name = "Car")
})
public interface Vehicle {
	String getName();
}
