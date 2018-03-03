package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    static public final  int MAX_TRUCK_SPEED = 80;
    static public final  int MAX_SEDAN_SPEED = 120;
    static public final  int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters){
        if (numberOfLiters < 0)
            throw new RuntimeException();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (!isSummer(date,SummerStart,SummerEnd)) {
            consumption = getWinterConsumption(length);
        } else {
            consumption = getSummerConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;

        return numberOfPassengers;
    }

    private boolean canPassengersBeTransferred(){
        return  (isDriverAvailable() && fuel > 0) ? true : false;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0)
            fastenPassengersBelts();
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers){
        Car result = null;
        if (type== 0){
            result = new Truck(numberOfPassengers);
        } else if (type ==1){
            result = new Sedan(numberOfPassengers);
        } else if (type == 2){
            result = new Cabriolet(numberOfPassengers);
        }
        return result;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd){

        return (date.before(summerStart) || date.after(summerEnd)) ? false : true;
    }

    public double getWinterConsumption(int length){
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length){
        return length * summerFuelConsumption;
    }
}