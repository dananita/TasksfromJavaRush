package com.javarush.task.task27.task2712.kitchen;

import java.util.StringJoiner;

/**
 * @author Daria Zhuravel
 * @date 03.04.18
 **/
public enum  Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString(){
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Enum e:values()) {
            stringJoiner.add(e.name());
        }
        return stringJoiner.toString();
    }
}
