package com.javarush.task.task25.task2502;

import java.util.*;

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
            wheels = new ArrayList<>();
            for (String weel:loadWheelNamesFromDB()) {

                if (Wheel.BACK_LEFT.toString().equalsIgnoreCase(weel)){
                    wheels.add(Wheel.BACK_LEFT);
                } else if (weel.equalsIgnoreCase(Wheel.BACK_RIGHT.name())){
                    wheels.add(Wheel.BACK_RIGHT);
                } else if (weel.equalsIgnoreCase(Wheel.FRONT_LEFT.toString())){
                    wheels.add(Wheel.FRONT_LEFT);
                } else if (weel.equalsIgnoreCase(Wheel.FRONT_RIGHT.toString())) {
                    wheels.add(Wheel.FRONT_RIGHT);
                } else {
                    throw  new UnsupportedOperationException();
                }

            }
            if (wheels==null||wheels.size() > 4|| wheels.size() < 4){
                throw  new UnsupportedOperationException();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }

        public  void print (){
            for (Wheel w:wheels) {
                System.out.println(w);
            }
        }

    public static void main(String[] args) {
        Car car = new Car();
        car.print();

        }
    }
}
