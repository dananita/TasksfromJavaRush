package com.javarush.task.task20.task2001;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/14", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            if (ivanov.equals(somePerson)){
                System.out.println("ivanov и somePerson равны");
                for (int i = 0; i <ivanov.assets.size() ; i++) {
                    System.out.println("Объект Ivanov"+ivanov.assets.get(i).hashCode());
                }

                for (int i = 0; i <somePerson.assets.size() ; i++) {
                    System.out.println("Объект SomePerson : "+somePerson.assets.get(i).hashCode());
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (this.name==null) {
                outputStream.write("NULL".getBytes());
            } else {
                outputStream.write(this.name.getBytes());
            }
            outputStream.write(" ".getBytes());

            for (int i = 0; i <this.assets.size() ; i++) {
                outputStream.write((this.assets.get(i).getName()+" ").getBytes());
                outputStream.write((Double.toString(this.assets.get(i).getPrice())+" ").getBytes());
            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            StringBuilder stringBuilder = new StringBuilder();
            while (inputStream.available()>0){
                stringBuilder.append((char)inputStream.read());
            }

            String[] strings = stringBuilder.toString().split(" ");

            if (!strings[0].equals("NULL")) this.name = strings[0];

            if (strings.length-2>0) {
                for (int i = 1; i < strings.length; i = i + 2) {
                    assets.add(new Asset(strings[i], Double.parseDouble(strings[i + 1])));
                }
            }
        }
    }
}
