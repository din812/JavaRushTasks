package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        int ID = 0;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case ("-c") :
                synchronized (allPeople) {
                    int currentIDlength = allPeople.size();
                    int nameStep = -2;
                    int sexStep = -1;
                    int bdStep = 0;

                    for (int i = 0; i < ((args.length - 1) / 3); i++) {
                        allPeople.add(allPeople.size(), args[sexStep += 3].equals("м")
                                ? Person.createMale(args[nameStep += 3], format.parse(args[bdStep += 3]))
                                : Person.createFemale(args[nameStep += 3], format.parse(args[bdStep += 3])));
                    }
                    for (; currentIDlength < allPeople.size(); ++currentIDlength) {
                        System.out.println(currentIDlength);
                    }
                } break;
            case ("-u") :
                synchronized (allPeople) {
                    int idStep = -3;
                    int nameStep = -2;
                    int sexStep = -1;
                    int bdStep = 0;

                    for (int i = 0; i < ((args.length - 1) / 3); i++) {
                        ID = Integer.parseInt(args[idStep += 4]);
                        allPeople.get(ID).setName(args[nameStep += 4]);
                        switch (args[sexStep += 4]) {
                            case ("м"):
                                allPeople.get(ID).setSex(Sex.MALE);
                                break;
                            case ("ж"):
                                allPeople.get(ID).setSex(Sex.FEMALE);
                                break;
                        }
                        allPeople.get(ID).setBirthDate(format.parse(args[bdStep += 4]));
                    }
                } break;

            case ("-d") :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        ID = Integer.parseInt(args[i]);
                        allPeople.get(ID).setName(null);
                        allPeople.get(ID).setSex(null);
                        allPeople.get(ID).setBirthDate(null);
                    }
                } break;

            case ("-i") :
                synchronized (allPeople) {
                    SimpleDateFormat sdfIinput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    for (int i = 1; i < args.length; i++) {
                        ID = Integer.parseInt(args[i]);
                        System.out.println(allPeople.get(ID).getName() + " " +
                                (allPeople.get(ID).getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                                sdfIinput.format(allPeople.get(ID).getBirthDate()));
                    }
                } break;
        }
    }
}
