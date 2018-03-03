package com.javarush.task.task29.task2909.car;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 02.03.18
 **/
public class Cabriolet extends  Car {
    public Cabriolet(int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
