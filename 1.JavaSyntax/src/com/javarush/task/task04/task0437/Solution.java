package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int m = 1;
        for(int i = 1; i <= 10; i++){
            for(int k = 1; k <= m; k++){
                System.out.print("8");
            }
            System.out.println();
            m++;
        }
       /* String s="";int m=1;
        for (int i = 1; i <= 11; i++) {
            for (int j = 1; j <= m; j++) {
                    s=s+8;
            }
            System.out.println(s);
            s="";
            m++;
        }*/
    }
}
