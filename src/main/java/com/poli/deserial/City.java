package com.poli.deserial;

import java.util.List;

public class City {
    private String name;
    //private Coordinates coord;
    private List<Building> buildings;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /* public Coordinates getCoord() {
        return coord;
    }
    public void setCoord(Coordinates coord) {
        this.coord = coord;
    } */
    public List<Building> getBuildings() {
        return buildings;
    }
    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }
}
