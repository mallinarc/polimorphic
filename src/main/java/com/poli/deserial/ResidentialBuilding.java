package com.poli.deserial;

public class ResidentialBuilding extends Building{
    private int noOfRooms;
    private String type;
    
    public int getNoOfRooms() {
        return noOfRooms;
    }
    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
