package com.javarush.task.task17.task1705;

import java.util.ArrayList;
import java.util.List;

/* 
Сад-огород
*/

public class Solution {


    public static void main(String[] args) {
    ThreadGarden threadA = new ThreadGarden();
    threadA.start();
    }

    public static class Garden {

        public final List<String> fruits = new ArrayList<String>();
        public final List<String> vegetables = new ArrayList<String>();

        public synchronized void addFruit(int index, String fruit){
            fruits.add(index, fruit);
        }

        public synchronized void removeFruit(int index){
            fruits.remove(index);
        }
        public synchronized void addVegetable(int index, String vegetable){
            vegetables.add(index,vegetable);
        }
        public synchronized void removeVegetable(int index){
            vegetables.remove(index);
        }
    }
    public static class ThreadGarden extends Thread{
        public void run(){
            synchronized (this){
                Garden t= new Garden();
                t.addFruit(0,"banana");
                t.removeFruit(0);
                t.addVegetable(0,"potato");
                t.removeVegetable(0);
            }
        }
    }
}
