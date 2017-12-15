package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream  implements AmigoStringWriter{
    private FileOutputStream fileOutputStream;


    public static void main(String[] args) {

    }
    public AdapterFileOutputStream (FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
    }

    @Deprecated
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Deprecated
    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }

    @Deprecated
    public void close() throws IOException {
        fileOutputStream.close();
    }
}

