package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Работа с датами
*/

public class Solution {

  public static void main(String[] args) throws ParseException {
    printDate("21.4.2014 15:56:45");
    System.out.println();
    printDate("21.4.2014");
    System.out.println();
    printDate("17:33:40");
  }

  public static void printDate(String date) throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.y");
    SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("H:m:s");
    Calendar calendar = Calendar.getInstance();
    if (date.contains(" ")) {
      String[] dateParts = date.split(" ");
      calendar.setTime(simpleDateFormat.parse(dateParts[0]));
      printLocalDate(calendar);
      calendar.setTime(simpleTimeFormat.parse(dateParts[1]));
      printLocalTime(calendar);
    } else if (date.contains(".")) {
      calendar.setTime(simpleDateFormat.parse(date));
      printLocalDate(calendar);
    } else if (date.contains(":")) {
      calendar.setTime(simpleTimeFormat.parse(date));
      printLocalTime(calendar);
    }
  }

  private static void printLocalDate(Calendar calendar) {
    System.out.println("День: " + calendar.get(Calendar.DATE));
    System.out.println("День недели: " + ((calendar.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7
        : calendar.get(Calendar.DAY_OF_WEEK) - 1));
    System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
    System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
    System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
    System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
    System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
    System.out.println("Год: " + calendar.get(Calendar.YEAR));
  }

  private static void printLocalTime(Calendar calendar) {
    System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
    System.out.println("Часы: " + calendar.get(Calendar.HOUR));
    System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
    System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
    System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
  }
}
