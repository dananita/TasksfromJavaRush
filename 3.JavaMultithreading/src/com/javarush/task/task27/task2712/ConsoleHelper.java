package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daria Zhuravel
 * @date 04.04.18
 **/
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        String customerDishNumber = "";
        ConsoleHelper.writeMessage("Введите номера блюд или exit для завершения ввода");
        ConsoleHelper.writeMessage(Dish.allDishesToString());
            while(true){
                if((customerDishNumber = readString()).equalsIgnoreCase("exit")){
                    break;
                }
                try {
                    dishes.add(Dish.valueOf(customerDishNumber));
                } catch (IllegalArgumentException e) {
                    ConsoleHelper.writeMessage("There is no such dish");
                }
            }
        return dishes;
    }
}
