package com.javarush.task.task24.task2413;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 18.02.18
 **/
public class Ball extends BaseObject {
    private double speed;
    private double direction;
    private double dx;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        this.dx = direction/speed;
        this.dy = direction/speed;
        isFrozen = true;
    }

    private double dy;
    private  boolean isFrozen;


    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }


    public Ball(double x, double y, double radius) {
        super(x,y,radius);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(getX(),getY(),'O');
    }

    public void start(){
        isFrozen =false;
        move();
    }

    @Override
    public void move() {
        if (isFrozen == false) {
            setX(getX() + dx);
            setY(getY() + dy);
        }
    }
}
