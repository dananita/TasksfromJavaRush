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

    public void checkBorders(SnakeSection head) {
        isAlive = (head.getX() >= Room.game.getWidth() || head.getX() < 0
                || head.getY() >= Room.game.getHeight() || head.getY() < 0
                        ? false : true);
    }

    public void checkBody(SnakeSection head) {
        if (getSections().contains(head)) {
            isAlive = false;
        }
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

    public void move(int dx, int dy){
        SnakeSection head = new SnakeSection(sections.get(0).getX()+dx,sections.get(0).getY()+dy);
        checkBorders(head);
        checkBody(head);
        if (isAlive){
            sections.add(0,head);
            if (head.getX() == Room.game.getMouse().getX()
                    && head.getY() == Room.game.getMouse().getY()){
                Room.game.eatMouse();
            } else {
                sections.remove(sections.size()-1);
            }
        }
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
