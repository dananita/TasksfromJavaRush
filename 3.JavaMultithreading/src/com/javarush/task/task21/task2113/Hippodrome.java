package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata @ yandex.ru)
 * @date 04.02.18
 **/
public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run(){
        try {
        for (int i = 0; i <100 ; i++) {
            move();
            print();
            Thread.sleep(200);
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        for (Horse horse:horses) {
            horse.print();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println();
        }
    }

    public void move(){
        for (Horse horse:horses) {
            horse.move();
        }

    }

    public static void main(String[] args) {
          Horse horse1 = new Horse("Kassandra",3,0);
          Horse horse2 = new Horse("Ivan",3,0);
          Horse horse3 = new Horse("Muskul",3,0);

          List<Horse> horses = new ArrayList();
          horses.add(horse1);
          horses.add(horse2);
          horses.add(horse3);
          
          game = new Hippodrome(horses);
    }

}
