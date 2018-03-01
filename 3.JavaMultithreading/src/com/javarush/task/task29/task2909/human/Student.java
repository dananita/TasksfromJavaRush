package com.javarush.task.task29.task2909.human;

import java.util.Date;

public class Student extends UniversityPerson implements Alive {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta){averageGrade+=delta;}

    public void setCourse(int course) {
        this.course = course;
    }

    public void setAverageGrade (double value){
        this.averageGrade = value;
    }

    @Override
    public String getPosition() { return "Студент"; }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public int getCourse() {
        return course;
    }
}