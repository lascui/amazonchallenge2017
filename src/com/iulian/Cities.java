package com.iulian;

import java.util.*;

public class Cities {

    public Cities(){
    }
    //key
    Map<Integer,Integer> locations = new HashMap<>();
    public void addCityToLocation(Integer k, Integer l){
        locations.put(k,l);
    }
    public void switchCities(Integer k1,Integer k2){
        Integer temp = locations.put(k1,k2);
        locations.put(k2,temp);
    }


    List<Integer> topdown = new ArrayList<>();
    List<Integer> bottomup = new ArrayList<>();

    void addToTopDownList(Integer k){
        topdown.add(k);
    }
    void addToBottomUpList(Integer k){
        bottomup.add(0,k);
    }


    Map<Integer,City> cityMap = new HashMap<>();
    List<City> byName = new ArrayList<>();
    private List<City> byConnections = new ArrayList<>();



    Comparator<City> byNameComparator =  new Comparator<City>() {
        public int compare(City c1, City c2) {
            return  c1.getName().compareTo(c2.getName());
        }
    };
    Comparator<City> byConnectionsComparator =  new Comparator<City>() {
        public int compare(City c1, City c2) {
            return  c1.getConnections().compareTo(c2.getConnections());
        }
    };

    void addCity(City c){
        if(!cityMap.containsKey(c.getName())){
            cityMap.put(c.getName(),c);
            byName.add(c);
            getByConnections().add(c);
        }
        sortCities();

    }

    private void sortCities(){
        Collections.sort(byName,byNameComparator);
        Collections.sort(byConnections,byConnectionsComparator);
    }

    public void updateCities(){
        sortCities();
    }
    // returns number of connections for city name
    Integer getCityConnectionsForName(Integer k){
        return byName.get(k).getConnections();
    }
    //returns first element in the list
    Integer getCityWithFewerConnections(){
        return getByConnections().get(0).getName();
    }
    //return last element in the list
    Integer getCityWithMostConnections(){
        return getByConnections().get(getByConnections().size()-1).getName();
    }


    public List<City> getByConnections() {
        return byConnections;
    }

    public void setByConnections(List<City> byConnections) {
        this.byConnections = byConnections;
    }
}
