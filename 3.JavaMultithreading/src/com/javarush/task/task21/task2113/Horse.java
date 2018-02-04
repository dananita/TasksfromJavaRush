package com.javarush.task.task21.task2113;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata @ yandex.ru)
 * @date 04.02.18
 **/
public class Horse {
    private String name;
    private double speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Horse(String name, double speed, double distance) {

        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    private double distance;

    public void move() {
    }

    public void print() {
    }
}
