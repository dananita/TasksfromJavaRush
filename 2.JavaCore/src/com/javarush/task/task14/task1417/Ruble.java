package com.javarush.task.task14.task1417;

/**
 * Alex Tingaev (tingaev@gmail.com) on 02.04.17.
 **/
public class Ruble extends Money{
    public Ruble(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "RUB";
    }
}
