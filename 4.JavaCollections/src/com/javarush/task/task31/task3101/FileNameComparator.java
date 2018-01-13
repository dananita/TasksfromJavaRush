package com.javarush.task.task31.task3101;

import java.io.File;
import java.util.Comparator;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata @ yandex.ru)
 * @date 13.01.18
 **/
public class FileNameComparator implements Comparator<File>{

    @Override
    public int compare(File first, File second) {

        return first.getName().compareTo(second.getName());
    }
}
