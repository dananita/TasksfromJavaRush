package com.javarush.task.task14.task1408;

/**
 * Alex Tingaev (tingaev@gmail.com) on 02.04.17.
 **/
public class RussianHen extends Hen {

        @Override
        int getCountOfEggsPerMonth() {
            return 12;
        }
        @Override
        public String getDescription() {
            return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        }
}
