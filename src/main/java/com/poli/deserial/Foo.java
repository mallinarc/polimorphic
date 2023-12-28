package com.poli.deserial;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class Foo {

	/*
	 * public static void main(String[] args) throws Exception {
	 * Foo app = new Foo();
	 * File file = new File(app.getClass().getClassLoader().getResource("input.json").getFile());
	 * ObjectMapper mapper = new ObjectMapper();
	 * mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	 * // mapper.setPropertyNamingStrategy(new CamelCaseNamingStrategy());
	 * mapper.addMixIn(Animal.class, PolymorphicAnimalMixIn.class);
	 * // mapper.addMixIn(Animal.class, PolymorphicAnimalMixIn.class);
	 * Town town = mapper.readValue(file, Town.class);
	 * System.out.println(mapper.writeValueAsString(town));
	 * for (Animal animal : town.getZoo().getAnimals()) {
	 * if (animal instanceof Cat) {
	 * Cat cat = (Cat) animal;
	 * System.out.println(cat.getFavoriteToy());
	 * }
	 * }
	 * }
	 */

	public static void main(String[] args) throws Exception {
		AnimalDeserializer deserializer = new AnimalDeserializer();
		deserializer.registerAnimal("leash_color", Dog.class);
		deserializer.registerAnimal("favorite_toy", Cat.class);
		deserializer.registerAnimal("wing_span", Bird.class);
		SimpleModule module = new SimpleModule("PolymorphicAnimalDeserializerModule");
		module.addDeserializer(Animal.class, deserializer);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// mapper.setPropertyNamingStrategy(new CamelCaseNamingStrategy());
		mapper.registerModule(module);
		Foo app = new Foo();
		Town zoo = mapper.readValue(app.getClass().getClassLoader().getResource("input.json").getFile(), Town.class);
		System.out.println(mapper.writeValueAsString(zoo));
	}

}
