package com.javarush.task.task24.task2413;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 18.02.18
 **/
public class Brick extends BaseObject{
    public Brick(double x, double y, double radius) {
        super(x, y, radius);
    }
    public Brick(double x, double y) {
        super(x, y, 3);
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {

    }
}
