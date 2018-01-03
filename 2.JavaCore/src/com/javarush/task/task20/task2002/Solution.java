package com.javarush.task.task20.task2002;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory
        // or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP
        // или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/15", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here
            // - инициализируйте поле users для объекта javaRush тут
            User ivanov = new User();
            ivanov.setFirstName("Ivan");
            ivanov.setLastName("Ivanov");
            ivanov.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("12-01-1955"));
            ivanov.setMale(true);
            ivanov.setCountry(User.Country.RUSSIA);
            javaRush.users.add(ivanov);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if(javaRush.equals(loadedObject)){
                System.out.println("Объекты равны");
            }
            System.out.println(loadedObject.users.get(0).getFirstName()+" "+
                    loadedObject.users.get(0).getLastName()+" "+
                    loadedObject.users.get(0).isMale()+" "+
                    loadedObject.users.get(0).getBirthDate()+" "+
                    loadedObject.users.get(0).getCountry());
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(this.users.size());
            for (User user:users) {
             printWriter.println(user.getFirstName());
             printWriter.println(user.getLastName());
             printWriter.println(String.valueOf(user.isMale()));

             if (user.getBirthDate()!=null)printWriter.println(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(user.getBirthDate()));
             else {printWriter.println("null");}
             if(user.getCountry()!=null)printWriter.println(user.getCountry().getDisplayedName());
             else {printWriter.println("null");}
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            /*StringBuilder stringBuilder = new StringBuilder();
            while(bufferedReader.ready()){
                stringBuilder.append(bufferedReader.readLine());
            }
            System.out.println(stringBuilder.toString());*/
            int cout = Integer.parseInt(bufferedReader.readLine());
            System.out.println(cout);
            String tempstring;
            for (int i = 0; i < cout; i++) {
                User user = new User();
                if(!(tempstring=bufferedReader.readLine()).equals("null")){
                user.setFirstName(tempstring);}
                if(!(tempstring=bufferedReader.readLine()).equals("null")){
                    user.setLastName(tempstring);
                }
                if(!(tempstring=bufferedReader.readLine()).equals("null")) {
                    user.setMale(Boolean.parseBoolean(tempstring));
                }
                if (!(tempstring = bufferedReader.readLine()).equals("null")) {
                    user.setBirthDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(tempstring));
                }
                if(!(tempstring=bufferedReader.readLine()).equals("null")) {
                    switch (tempstring) {
                        case "Russia": {
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        }
                        case "Ukraine": {
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        }
                        case "Other": {
                            user.setCountry(User.Country.OTHER);
                            break;
                        }
                        case "null": {
                            user.setCountry(null);
                        }
                    }
                }
                this.users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
