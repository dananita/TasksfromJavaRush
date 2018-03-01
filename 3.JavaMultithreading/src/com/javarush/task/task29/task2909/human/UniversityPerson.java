package com.javarush.task.task29.task2909.human;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 02.03.18
 **/
public class UniversityPerson extends Human{
    private University university;

    public void setUniversity(University university) {
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public UniversityPerson(String name, int age) {
        super(name, age);
    }
}
