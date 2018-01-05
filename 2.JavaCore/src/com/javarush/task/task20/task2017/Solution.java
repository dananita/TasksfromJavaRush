package com.javarush.task.task20.task2017;

import org.omg.CORBA.AnySeqHelper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
          A result;
            try {
                result = (A) objectStream.readObject();
            } catch (Exception e) {
                result = null;
            }
        return result;
    }

    public class A  implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        A a = solution.new A();
        System.out.println(a.toString());
        B b = solution.new B();
        System.out.println(b.toString());
    }
}
