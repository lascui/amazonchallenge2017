package com.iulian;

import java.nio.file.Paths;
import java.util.*;

public class Main {
    static Cities cities = new Cities();
    static Connections conns = new Connections();
//    static Map map = new HashMap<Integer, Vector<Integer>>();
//    static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) {
            try {
                Scanner in = new Scanner(Paths.get("./input16.txt"));
                //read number of cities and highways
                Integer orase_initial = in.nextInt();
                Integer conexiuni_initial = in.nextInt();
                Integer orase_final=orase_initial;
                Integer conexiuni_final;
                System.out.printf("initial orase %s conexiuni %s%n", orase_initial.toString(), conexiuni_initial.toString());
                //combinari C0 cate 2
                Integer combinatii_initial = (orase_initial*(orase_initial-1))/2;
                Integer combinatii_final = combinatii_initial;
//                System.out.println(combinatii_initial.toString());

                //read highways, populate connections map
                for(int a0 = 1; a0 <= conexiuni_initial; a0++){
                    int a1 = in.nextInt();
                    int a2 = in.nextInt();
                    conns.addConnectionsBetweenCities(a1,a2);
                }
                Boolean added=false;
                for(int a0=1;a0 <= conexiuni_initial;a0++){
                    if (conns.getSetOfConnectionsForKey(a0).size() == (orase_initial-1)){
                        orase_final++;
                        added = true;
                    }
                }
                //minus 1 if there were added
                if(added) orase_final-=1;

                combinatii_final = (orase_final*(orase_final-1))/2;
//                System.out.printf("final1 %s %s\n", combinatii_final, orase_final);

                while ((combinatii_final % 2 != 0 )&&
                        (combinatii_final<=2*conexiuni_initial) &&
                        (++orase_final >0)){
                    combinatii_final = (orase_final*(orase_final-1))/2;
                }
                //number of cities to build
                System.out.printf("final2 orase %s connexiuni %s\n", orase_final, combinatii_final);
//                System.out.printf("orase adaugate %s rute adaugate %s\n",orase_final-orase_initial,combinatii_final/2-conexiuni_initial);

                //adding cities to initial locations, old and newly built
                for (int a0=1;a0<=orase_final;a0++){
                    cities.addCity(new City(a0,a0,conns.getNumberOfConnectionsForCity(a0)));
                }

                for (City c1:cities.getByConnections()){
                    for (City c2:cities.getByConnections()){
                        if(!c1.getName().equals(c2.getName())){
                            if(!conns.getSetOfConnectionsForKey(c2.getName()).contains(c1.getName())){
                                conns.addNewConnection(c1.getName(),c2.getName());
                                c1.setConnections(c1.getConnections()+1);
                                c2.setConnections(c2.getConnections()+1);
                                cities.updateCities();
                            }
                        }
                    }
                    System.out.printf("%s %s %s\n",c1.getName(),c1.getLocation(),c1.getConnections());
                }

//                System.out.printf("city with most connections %s %s\n",cities.getCityWithMostConnections(),
//                        cities.getCityConnectionsForName(cities.getCityWithMostConnections()-1));
//                System.out.printf("city with less connections %s %s\n",cities.getCityWithFewerConnections(),
//                        cities.getCityConnectionsForName(cities.getCityWithFewerConnections()-1));




            }
            catch (Exception e) {
                System.out.println(e);
            }

        }
    }

