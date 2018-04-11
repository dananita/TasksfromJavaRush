package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daria Zhuravel
 * @date 11.04.18
 **/

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    public Shop() {
    }

    @XmlType(name = "goods")
    public static class Goods {
        public List<String> names = new ArrayList<>();

        public Goods() {
        }
    }
}
