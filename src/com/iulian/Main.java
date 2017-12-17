package com.iulian;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Math.ceil;

public class Main {
    static Cities cities = new Cities();
    static Connections conns = new Connections();

    //    static Map map = new HashMap<Integer, Vector<Integer>>();
//    static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) {
        Integer orase_initial;
        Integer conexiuni_initial;
        Integer orase_final;
        Integer conexiuni_final;
        Boolean added;
        try (Scanner in = new Scanner(Paths.get("./14_SEA.txt"))) {
            //read number of cities and highways
            orase_initial = in.nextInt();
            conexiuni_initial = in.nextInt();
            orase_final = orase_initial;
            System.out.printf("initial orase %s conexiuni %s%n", orase_initial, conexiuni_initial);
            //combinari C0 cate 2
            Integer combinatii_initial = (orase_initial * (orase_initial - 1)) / 2;
            System.out.printf("initial orase %s conexiuni %s %s\n", orase_initial, combinatii_initial,(combinatii_initial%2==0));
            conexiuni_final = combinatii_initial;

            //orase_final = 4k+1
            if((orase_initial % 4 == 0) || (orase_initial % 4 == 1)){
               orase_final=orase_initial;
            } else{
               orase_final = 4* (orase_initial/4+1)+1;
            }
            conexiuni_final = (orase_final * (orase_final - 1)) / 2;
            System.out.printf("final orase %s conexiuni %s%n", orase_final, conexiuni_final);
//                System.out.println(combinatii_initial.toString());
            //half of combinatii_initial should be even

            //read highways, populate connections map
            for (int a0 = 1; a0 <= conexiuni_initial; a0++) {
                int a1 = in.nextInt();
                int a2 = in.nextInt();
                conns.addConnectionsBetweenCities(a1, a2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        added = false;
    }
}

