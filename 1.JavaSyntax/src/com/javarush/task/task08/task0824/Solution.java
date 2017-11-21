package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import com.sun.xml.internal.ws.api.message.HeaderList;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human son2 = new Human("Kuza",true,4);
        Human son = new Human("Oleg",true,2);
        Human dauther = new Human("Ira",false,3);
        ArrayList list = new ArrayList();
        Collections.addAll(list,son,son2,dauther);
        Human mother = new Human("Alica", false,22,list);

        ArrayList list1 = new ArrayList();
        list1.add(mother);
        Human grandfather = new Human("Marin",true,65,list1);
        Human grandmother = new Human("Kate",false,60,list1);

        Human father = new Human("Sven",true,23,list);

        ArrayList list2 = new ArrayList();
        list2.add(father);
        Human grandfather2 = new Human("Duk",true,75,list2);
        Human grandmother2 = new Human("Svetlana",false,65,list2);
        System.out.println(grandfather);
        System.out.println(grandfather2);
        System.out.println(grandmother2);
        System.out.println(grandmother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son2);
        System.out.println(son);
        System.out.println(dauther);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;
        //напишите тут ваш код
        public Human(String name,boolean sex, int age, ArrayList children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        public Human(String name,boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children =null;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.children!=null){
            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }}
            return text;
        }
    }

}
