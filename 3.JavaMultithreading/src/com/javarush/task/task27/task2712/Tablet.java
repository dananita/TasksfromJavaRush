package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Daria Zhuravel
 * @date 03.04.18
 **/
public class Tablet {
    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder(){
        try {
            Order order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
        } catch (Exception e){
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
    }

    @Override
    public String toString() {
        return String.format("Tablet{number=%d}",number);
    }
}
