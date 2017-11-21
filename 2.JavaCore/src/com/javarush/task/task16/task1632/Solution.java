package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
     Thread thread1 = new Thread1();
     Thread thread2 = new Thread2();
     Thread thread3 = new Thread3();
     Thread thread4 = new Thread4();
     Thread thread5 = new Thread5();
     threads.add(thread1);
     threads.add(thread2);
     threads.add(thread3);
     threads.add(thread4);
     threads.add(thread5);
    }
    public static void main(String[] args) {

    }
    public static class Thread1 extends Thread{
        public void run(){
            while (true){

            }
        }
    }

    public static class Thread2 extends Thread{
        public void run(){
            while (true){
                if (interrupted()){
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Thread3 extends Thread{
        public void run(){
                while (true) {
                    System.out.println("Ура!");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public static class Thread4 extends Thread implements Message{
        public void run(){
            showWarning();
        }

        @Override
        public void showWarning() {
            this.stop();
        }
    }
    public static class Thread5 extends Thread{
        public void run() {
            BufferedReader rd=new BufferedReader(new InputStreamReader(System.in)); int e=0; String s; boolean flag=true; try { while(flag) { s=rd.readLine(); if(s.equals("N")) flag=false; e=e+Integer.parseInt(s); } } catch (Exception ex){System.out.println(e);} }
    }

}