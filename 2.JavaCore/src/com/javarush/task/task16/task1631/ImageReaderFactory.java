package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata @ yandex.ru)
 * @date 20.11.17
 **/
public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes picture) throws IllegalArgumentException{
            if (picture==null)throw new IllegalArgumentException("Неизвестный тип картинки");
            switch (picture) {
                case BMP: return new BmpReader();
                case JPG: return new JpgReader();
                case PNG: return new PngReader();
            }
        throw (new IllegalArgumentException("Неизвестный тип картинки"));
    }
}
