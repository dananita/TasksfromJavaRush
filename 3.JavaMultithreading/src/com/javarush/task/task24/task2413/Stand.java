package com.javarush.task.task24.task2413;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 18.02.18
 **/
public class Stand extends BaseObject{
    private double speed;
    private double direction;

    public Stand(double x, double y, double radius) {
        super(x, y, radius);
    }

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {
        setX(getX() + (direction * speed));
    }

    public void moveLeft(){
        this.direction = -1;
    }

    public void moveRight(){
        this.direction = 1;
    }
}
