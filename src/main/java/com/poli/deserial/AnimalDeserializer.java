package com.poli.deserial;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class AnimalDeserializer extends StdDeserializer<Animal> {
	private Map<String, Class<? extends Animal>> registry = new HashMap<String, Class<? extends Animal>>();

	AnimalDeserializer() {
		super(Animal.class);
	}

	void registerAnimal(String uniqueAttribute,
			Class<? extends Animal> animalClass) {
		registry.put(uniqueAttribute, animalClass);
	}

	@Override
	public Animal deserialize(
			JsonParser jp,
			DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		ObjectMapper mapper = (ObjectMapper) jp.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(jp);
		Class<? extends Animal> animalClass = null;
		Iterator<Entry<String, JsonNode>> elementsIterator = root.fields();
		while (elementsIterator.hasNext()) {
			Entry<String, JsonNode> element = elementsIterator.next();
			String name = element.getKey();
			if (registry.containsKey(name)) {
				animalClass = registry.get(name);
				break;
			}
		}
		if (animalClass == null) return null;
		return mapper.convertValue(root, animalClass);
	}
}
