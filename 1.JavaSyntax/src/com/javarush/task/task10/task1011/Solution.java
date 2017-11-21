package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {

        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        for (int i = 0; i < 40; i++) {
            System.out.println(s.substring(i).trim());
        }
/*            StringBuilder buff = new StringBuilder(s);
            int i=1,count=0;
        System.out.println(s);
        while ((buff.length()-1>0)&&count+3<=40){
            count++;
            if (buff.charAt(i) == ' ') {
                buff.delete(0, i);
            }
            else {
                //if (buff.charAt(i-1)=='х') break;
                //else {
                    buff.delete(0, i);
                  if (count%2==0) System.out.println(buff);
                    System.out.println(buff);
                //}
            }
*/
        /*for (int j = s.indexOf('х')+1; j <=40 ; j++) {
            System.out.println(buff);
        }
    }*/
    }
}

