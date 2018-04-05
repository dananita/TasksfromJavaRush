package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * @author Daria Zhuravel
 * @date 03.04.18
 **/
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty())
            return "";
        return String.format("Your order: %s of %s, cooking time %d" + "min", dishes.toString(), tablet.toString(), getTotalCookingTime());
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public int getTotalCookingTime(){ //время приготовления еды
        int timeAllOrder = 0;
        for (Dish d: dishes) {
            timeAllOrder += d.getDuration();
        }
        return timeAllOrder;
    }
}
