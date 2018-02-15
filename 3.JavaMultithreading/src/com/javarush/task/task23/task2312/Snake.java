package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 13.02.18
 **/
public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake (int x, int y){
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x,y));
        setAlive(true);
    }

    public int getX(){
        return sections.get(0).getX();
    }

    public int getY(){
        return sections.get(0).getY();
    }

    public void move(){
        if (isAlive){
            if (direction == SnakeDirection.UP) {
                move(0, -1);
            } else if (direction == SnakeDirection.RIGHT) {
                move(1, 0);
            } else if (direction == SnakeDirection.DOWN) {
                move(0, 1);
            } else {
                move(-1, 0);
            }
        }
    }

    public void move(int x, int y){

    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }
}
