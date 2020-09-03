package com.javarush.task.task17.task1710;

import java.io.IOException;
import java.text.*;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        int ID;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case ("-c") :
                allPeople.add(allPeople.size(), args[2].equals("м") ? Person.createMale(args[1], format.parse(args[3]))
                                                                    : Person.createFemale(args[1], format.parse(args[3])));
                System.out.println(allPeople.size()-1); break;
            case ("-u") :
                ID = Integer.parseInt(args[1]);
                allPeople.get(ID).setName(args[2]);
                if (args[3].equals("м")) {
                    allPeople.get(ID).setSex(Sex.MALE);
                } else {
                    allPeople.get(ID).setSex(Sex.FEMALE);
                }
                allPeople.get(ID).setBirthDate(format.parse(args[4])); break;
            case ("-d") :
                ID = Integer.parseInt(args[1]);
                allPeople.get(ID).setName(null);
                allPeople.get(ID).setSex(null);
                allPeople.get(ID).setBirthDate(null); break;

            case ("-i") :
                ID = Integer.parseInt(args[1]);
                SimpleDateFormat sdfIinput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.println(allPeople.get(ID).getName() + " " +
                                    (allPeople.get(ID).getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                                    sdfIinput.format(allPeople.get(ID).getBirthDate()));
        }
    }
}
