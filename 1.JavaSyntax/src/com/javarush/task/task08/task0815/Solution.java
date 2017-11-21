package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap();
        map.put("Москвел","Ирина");
        map.put("Иванова","Валентина");
        map.put("Вел","Соня");
        map.put("Сальк","Вероника");
        map.put("Велв","Алена");
        map.put("Велм","Зиннаида");
        map.put("Кульк","Карина");
        map.put("Мульк","Инна");
        map.put("Велс","Лерика");
        map.put("Вела","Валентина");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int firstnamecount=0;
        for(String p :map.values()){
            if (p.intern()==name.intern()){
                firstnamecount++;
            }
        }
    return firstnamecount;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int lastnamecount=0;
        for(String p :map.keySet()){
            if (p.intern()==lastName.intern()){
                lastnamecount++;
            }
        }
        return lastnamecount;
    }

    public static void main(String[] args) {
    HashMap map = createMap();
    int f = getCountTheSameFirstName(map,"Валентина");
    int l = getCountTheSameLastName(map,"Вел");
   //     System.out.println("f="+f+", l="+l);
    }
}
