package com.javarush.task.task23.task2312;

import java.util.List;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 13.02.18
 **/
public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    private SnakeDirection direction;

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
