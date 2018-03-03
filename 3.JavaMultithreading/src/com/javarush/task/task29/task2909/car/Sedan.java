package com.javarush.task.task29.task2909.car;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 02.03.18
 **/
public class Sedan extends Car {

    public Sedan(int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
