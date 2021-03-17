package com.poli.deserial;

public class Root {
    private String message;
    private String cod;
    //private int count;
    private City city;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }
    /* public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    } */
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }   
}
