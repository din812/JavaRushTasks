package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate bd = LocalDate.parse(birthday, formatter);
        LocalDate reqDate = bd.withYear(Year.parse(year).getValue());
        return reqDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}
