package com.javarush.task.task22.task2213;

/**
 * @author Daria Zhuravel
 * @date 11.04.18
 **/
public class Tetris {
    private Field field;
    private Figure figure;
    public static Tetris game;

    public Field getField() {
        return field;
    }

    public Figure getFigure() {
        return figure;
    }

    public void run(){

    }
    public void step(){
        
    }
    public static void main(String[] args) {
        game = new Tetris();
        game.run();
    }
}
