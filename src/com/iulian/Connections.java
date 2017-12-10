package com.iulian;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Connections {
    public Connections() {
    }

    private Map<Integer,HashSet<Integer>> initialConnections = new HashMap<>();

    // return all connections for a city
    public HashSet<Integer> getSetOfConnectionsForKey (Integer k){
        return ((HashSet<Integer>)initialConnections.getOrDefault(k,new HashSet<>()));
    }

    //return the number of connections for a city, zero if it is not connected
    Integer getNumberOfConnectionsForCity(Integer k){
        return initialConnections.getOrDefault(k,new HashSet<Integer>()).size();
    }

    Integer getTotalNumberOfConnections(){
        return initialConnections.size();
    }

    //return if there's a connection between the two cities
    public Boolean checkIfCitiesAreConnected(Integer k1, Integer k2){
        if (getSetOfConnectionsForKey(k1).contains(k2)) return Boolean.TRUE;
        return Boolean.FALSE;
    }
    //add connection between two cities
   public void addConnectionsBetweenCities(Integer k1,Integer k2){
        if( !initialConnections.containsKey(k1)){
            initialConnections.put(k1,new HashSet<>());
        }
        ((HashSet<Integer>)initialConnections.get(k1)).add(k2);
        if( !initialConnections.containsKey(k2)){
            initialConnections.put(k2,new HashSet<>());
        }
        ((HashSet<Integer>)initialConnections.get(k2)).add(k1);
    }

    private Map<Integer,Integer> newconnections = new HashMap<>();
    public void addNewConnection(Integer k1, Integer k2){
       if(!newconnections.containsKey(k1)){
           newconnections.put(k1,k2);
       }
   }
}
