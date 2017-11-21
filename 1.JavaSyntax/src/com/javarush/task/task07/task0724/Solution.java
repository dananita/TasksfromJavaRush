package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
//        Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
//        Имя: Катя, пол: женский, возраст: 55
//        Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
        Human human1 = new Human("Павел2",true,56);
        Human human6 = new Human("Катя2",false,71);
        Human human5 = new Human("Михаил2",true,73);
        Human human7 = new Human("Аня2",false,60);
        System.out.println(human1);
        System.out.println(human6);
        System.out.println(human5);
        System.out.println(human7);

        Human human2 = new Human("Катя",false,18,human1,human6);
        Human human3 = new Human("Вася",false,21,human5,human7);
        System.out.println(human2);
        System.out.println(human3);
        Human human4 = new Human("Михаил",true,3,human2,human3);
        Human human9 = new Human("Аня",true,1,human2,human3);
        Human human8 = new Human("Игорь",true,2,human2,human3);


        System.out.println(human4);
        System.out.println(human9);
        System.out.println(human8);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;
        Human(String name, boolean sex,int age, Human father,Human mother){
            this.name =name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this. mother = mother;
        }
        Human(String name, boolean sex,int age){
            this.name =name;
            this.sex = sex;
            this.age = age;
        }
        Human(String name){
            this.name=name;
        }
        //напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















