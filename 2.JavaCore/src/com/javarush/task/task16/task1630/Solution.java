package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static{
        BufferedReader file1 = new BufferedReader( new InputStreamReader(System.in));
        try {
            firstFileName = file1.readLine();
            secondFileName = file1.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fileName;
        private String fileContent="";
        @Override
        public void setFileName(String fullFileName) {
            fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

        @Override
        public  void run(){
            try {
                BufferedReader buf = new BufferedReader(new FileReader(new File(fileName)));
                String str;
                while ((str = buf.readLine())!=null){
                    fileContent += str+ " ";
                }
                buf.close();

            }catch (FileNotFoundException e){
                System.out.println("Error2!");
            }catch (IOException e) {
                System.out.println("Error!");
            }catch (NullPointerException e){
                System.out.println("Error3!");
            }
        }
    }
}
