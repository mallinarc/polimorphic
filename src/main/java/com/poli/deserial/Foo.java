package com.poli.deserial;

import java.io.File;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Foo {

	/*
	 * public static void main(String[] args) throws Exception {
	 * AnimalDeserializer deserializer = new AnimalDeserializer();
	 * deserializer.registerAnimal("leash_color", Dog.class);
	 * deserializer.registerAnimal("favorite_toy", Cat.class);
	 * deserializer.registerAnimal("wing_span", Bird.class);
	 * @SuppressWarnings("deprecation") SimpleModule module = new SimpleModule("PolymorphicAnimalDeserializerModule", new Version(1, 0, 0, null));
	 * module.addDeserializer(Animal.class, deserializer);
	 * ObjectMapper mapper = new ObjectMapper();
	 * // mapper.setPropertyNamingStrategy(new CamelCaseNamingStrategy());
	 * mapper.registerModule(module);
	 * Zoo zoo = mapper.readValue(new File("input_6.json"), Zoo.class);
	 * System.out.println(mapper.writeValueAsString(zoo));
	 * }
	 */
	public static void main(String[] args) throws Exception {
		Foo app = new Foo();
		File file = new File(app.getClass().getClassLoader().getResource("input.json").getFile());
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// mapper.setPropertyNamingStrategy(new CamelCaseNamingStrategy());
		mapper.addMixIn(Animal.class, PolymorphicAnimalMixIn.class);
		// mapper.addMixIn(Animal.class, PolymorphicAnimalMixIn.class);
		Zoo zoo = mapper.readValue(file, Zoo.class);
		System.out.println(mapper.writeValueAsString(zoo));

		for (Animal animal : zoo.getAnimals()) {
			if (animal instanceof Cat) {
				Cat cat = (Cat) animal;
				System.out.println(cat.getFavoriteToy());
			}
		}
	}

}
