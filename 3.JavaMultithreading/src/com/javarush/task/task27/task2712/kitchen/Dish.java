package com.javarush.task.task27.task2712.kitchen;

import java.util.StringJoiner;

/**
 * @author Daria Zhuravel
 * @date 03.04.18
 **/
public enum  Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int i) {
        this.duration = i;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Enum e:values()) {
            stringJoiner.add(e.name());
        }
        return stringJoiner.toString();
    }
}
