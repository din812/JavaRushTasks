package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new ArrayList<Wheel>();
            try {
                if (loadWheelNamesFromDB().length == 4) {
                    for (String wheelFromDb :
                            loadWheelNamesFromDB()) {
                        wheels.add(Wheel.valueOf(wheelFromDb));
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        System.out.println(new Car().wheels);
    }
}
