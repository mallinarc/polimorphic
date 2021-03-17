package com.poli.deserial;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class BuildingsMain {
    public static void main(String[] args) throws IOException {
        System.out.println();

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        BuildingsMain bldMain = new BuildingsMain();

        SimpleModule usageModule = new SimpleModule().addDeserializer(Root.class, new BuildingListDeserializer());
        mapper.registerModule(usageModule);
        Root root = mapper.readValue(new File(bldMain.getClass().getClassLoader().getResource("buildings.json").getFile()), Root.class);
        System.out.println(mapper.writeValueAsString(root));        
    }
}
