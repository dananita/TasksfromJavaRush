package com.javarush.task.task24.task2413;

import java.util.List;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 18.02.18
 **/
public class Arkanoid {
    private int width;
    private int height;

    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;

    private boolean isGameOver;

    static Arkanoid game;

    public void run(){

    }

    public void checkBricksBump(){
        for (int i = bricks.size() - 1; i >= 0; i--) {
            if (ball.isIntersec(bricks.get(i))) {
                double angle = Math.random() * 360;
                ball.setDirection(angle);
                bricks.remove(i);
                break;
            }
        }
    }
    public void checkStandBump(){
        if(!stand.isIntersec(ball)){
            double angle = 90 + 20* (Math.random()-0.5);
            ball.setDirection(angle);
        }
    }
    public void checkEndGame(){
       if (ball.getY() > height)
           isGameOver = true;
    }
    public void move(){
        ball.move();
        stand.move();
        
    }

    public void draw(Canvas canvas){
        ball.draw(canvas);
        for (Brick b:bricks) {
            b.draw(canvas);
        }
        stand.draw(canvas);
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
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

    public static void main(String[] args) {

    }
}
