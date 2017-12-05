package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends OutputStream {
    private FileOutputStream original;
    public static String fileName = "/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/result.txt";

    public AmigoOutputStream(FileOutputStream original){
        super ();
        this.original = original;
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }

    @Override
    public void close() throws IOException {
        original.flush();
        original.write("JavaRush © All rights reserved.".getBytes());
        original.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
