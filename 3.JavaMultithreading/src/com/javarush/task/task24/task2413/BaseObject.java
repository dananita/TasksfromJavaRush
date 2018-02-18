package com.javarush.task.task24.task2413;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 18.02.18
 **/
public abstract class BaseObject {
    protected double x;
    protected double y;
    protected double radius;

    public abstract void draw(Canvas canvas);

    public abstract void  move();

    public boolean isIntersec(BaseObject o){
        return Math.sqrt(Math.pow(this.getX()-o.getX(),2)+Math.pow(this.getY()-o.getY(),2))<=Math.max(this.getRadius(),o.getRadius()) ? true:false;
    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
