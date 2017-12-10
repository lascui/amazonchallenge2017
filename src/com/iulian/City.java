package com.iulian;


public class City {
    private Integer name;
    private Integer location;
    private Integer connections;
    private Boolean canaddconnections;
    
    public Boolean getCanaddconnections() {
        return canaddconnections;
    }

    public void setCanaddconnections(Boolean canaddconnections) {
        this.canaddconnections = canaddconnections;
    }


    public  City (Integer n, Integer l, Integer c){
        this.name = n;
        this.location = l;
        this.connections = c;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getConnections() {
        return connections;
    }

    public void setConnections(Integer connections) {
        this.connections = connections;
    }
}
