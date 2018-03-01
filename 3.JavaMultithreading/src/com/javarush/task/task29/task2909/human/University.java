package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University{
    private List <Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students.add(new Student(name,age,0));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        int resultAverageGrade = 0;
        for (int i = 0; i < students.size() ; i++) {
            if (students.get(i).getAverageGrade()==averageGrade) {
                resultAverageGrade = i;
            }
        }
        //TODO:
        return students.get(resultAverageGrade);
    }

    public Student getStudentWithMaxAverageGrade() {
        int resultAverageGrade = 0;
        double maxAverageGrade = 0;
        for (int i = 0; i < students.size() ; i++) {
            if (students.get(i).getAverageGrade() > maxAverageGrade){
                maxAverageGrade = students.get(i).getAverageGrade();
                resultAverageGrade = i;
            }
        }
        //TODO:
        return students.get(resultAverageGrade);
    }

    public Student getStudentWithMinAverageGrade(){
        int resultAverageGrade = 0;
        double minAverageGrade = getStudentWithMaxAverageGrade().getAverageGrade();
        for (int i = 0; i < students.size() ; i++) {
            if (students.get(i).getAverageGrade() < minAverageGrade){
                minAverageGrade = students.get(i).getAverageGrade();
                resultAverageGrade = i;
            }
        }
        //TODO:
        return students.get(resultAverageGrade);
    }
    public void expel(Student student){
        students.remove(student);
    }
}