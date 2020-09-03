package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("D:\\project\\JavaRushTasks\\Lion.txt");
            InputStream inputStream = new FileInputStream("D:\\project\\JavaRushTasks\\Lion.txt");

            JavaRush javaRush = new JavaRush();

            User user = new User();
            user.setFirstName("asdqw");
            user.setLastName("EYyyh");
            user.setBirthDate(new Date(1238912316134L));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);

            User user1 = new User();
            user1.setFirstName("Ahhe");
            user1.setLastName("WThe4");
            user1.setBirthDate(new Date(1238934516163L));
            user1.setMale(true);
            user1.setCountry(User.Country.OTHER);

            User user3 = new User();
            user3.setFirstName("WTWgg");
            user3.setLastName("Wtrg");
            user3.setBirthDate(new Date(5341144516169L));
            user3.setMale(true);
            user3.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user);
            javaRush.users.add(user1);
            javaRush.users.add(user3);


            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            //System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pr = new PrintWriter(outputStream);

            String isCatPresent = users.size() != 0 ? "yes" : "no";
            pr.println(isCatPresent);
            pr.println(users.size());
            if (!users.isEmpty()) {
                for (User user : users) {
                    pr.println(user.getFirstName());
                    System.out.println(user.getFirstName());
                    pr.println(user.getLastName());
                    System.out.println(user.getLastName());
                    pr.println(user.getBirthDate().getTime());
                    System.out.println(user.getBirthDate().getTime());
                    pr.println(user.isMale());
                    System.out.println(user.isMale());
                    pr.println(user.getCountry().getDisplayName());
                    System.out.println(user.getCountry().getDisplayName());
                }
            }
            pr.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String isCatPresent = reader.readLine();
            int amountOfPeople = Integer.parseInt(reader.readLine());
            if (isCatPresent.equals("yes")) {
                for (int i = 0; i < amountOfPeople; i++) {
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    user.setBirthDate(new Date((Long.parseLong(reader.readLine()))));
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    user.setCountry(User.Country.valueOf(reader.readLine().toUpperCase()));
                    users.add(user);
                }
            }
            reader.close();
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
