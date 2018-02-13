package com.javarush.task.task23.task2312;

import java.util.Random;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 13.02.18
 **/
public class Room {
    public static Room game;
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void run(){
        sleep();
    }

    public void sleep(){
    int s = snake.getSections().size();
        try {
            Thread.sleep(1000/(s*200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print(){

    }
    public void createMouse(){
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        Mouse mouse = new Mouse(x,y);
        setMouse(mouse);
    }
    public void eatMouse(){
        createMouse();
    }

    public static void main(String[] args) {
        Snake snake = new Snake(10,10);
        game = new Room(140, 270, snake);
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }
}
