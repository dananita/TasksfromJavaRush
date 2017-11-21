package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/


public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.UKRAINE);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            if (country=="Russia")  {return new RussianHen();}
            if (country=="Belarus") {return new BelarusianHen();}
            if (country=="Ukraine") {return new UkrainianHen();}
            if (country=="Moldova") {return new MoldovanHen();}
            return hen;
        }
    }
}
