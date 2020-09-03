package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        SimpleDateFormat sDF = new SimpleDateFormat("dd MM yyyy");
        while ((line = reader.readLine()) != null) {
            PEOPLE.add(new Person(line.replaceAll("\\d", "").trim(), sDF.parse(line.replaceAll("\\D", " "))));
        }
        reader.close();
    }
}
