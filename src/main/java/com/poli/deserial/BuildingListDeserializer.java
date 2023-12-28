package com.poli.deserial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BuildingListDeserializer extends JsonDeserializer<Root> {
	private static ObjectMapper mapper = new ObjectMapper();

	@Override
	public Root deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		Class<? extends Building> clazz = null;
		Root root = new Root();
		List<Building> buildings = new ArrayList<Building>();
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode eventListNode = oc.readTree(jsonParser);

		Iterator<Entry<String, JsonNode>> elementsIterator = eventListNode.fields();

		while (elementsIterator.hasNext()) {
			Entry<String, JsonNode> element = elementsIterator.next();
			String name = element.getKey();
			System.out.println(".... name of the field:" + name + "...Value:" + element.getValue());
			if (name.equals("type") && element.getValue().equals("residential")) {
				clazz = ResidentialBuilding.class;
			} else if (name.equals("type") && element.getValue().equals("commercial")) {
				clazz = CommercialBuilding.class;
			}
			/* ArrayNode node = (ArrayNode) eventListNode.get("evt"); */
			/*
			 * Iterator<JsonNode> events = node.elements();
			 * for (; events.hasNext(); )
			 * {
			 * JsonNode eventNode = events.next();
			 * int eventType = eventNode.get("type").asInt();
			 * Event event;
			 * if (eventType == EventTypes.MoveEvent.getValue())
			 * {
			 * event = mapper.readValue(eventNode.toString(), MoveEvent.class);
			 * }
			 * else if (eventType == EventTypes.CopyEvent.getValue())
			 * {
			 * event = mapper.readValue(eventNode.toString(), CopyEvent.class);
			 * }
			 * else
			 * {
			 * throw new InvalidEventTypeException("Invalid event type:" + eventType);
			 * }
			 * listOfEvents.add(event);
			 * }
			 * eventList.setEvents(listOfEvents);
			 * return eventList;
			 */

		}
		return root;
	}

}
