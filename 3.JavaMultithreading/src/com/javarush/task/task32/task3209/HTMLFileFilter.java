package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * @author Daria Zhuravel
 * @date 01.04.18
 **/
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return (f.getName().endsWith(".html")||f.getName().endsWith(".HTML")
                ||f.getName().endsWith(".htm")||f.getName().endsWith(".HTM")||f.isDirectory()) ? true : false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
