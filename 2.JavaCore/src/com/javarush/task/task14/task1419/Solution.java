package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            String a = null; //null value
            System.out.println(a.charAt(0));

        } catch (NullPointerException e) {
            exceptions.add(e);
        }
        try {
            String a = "This is like chipping "; // length is 22
            char c = a.charAt(24); // accessing 25th element
            System.out.println(c);

        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            // Following file does not exist
            File file = new File("E://file.txt");

            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }
        try {
            // "akki" is not a number
            int num = Integer.parseInt ("akki") ;

            System.out.println(num);
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        try {
            int a[] = new int[5];
            a[6] = 9; // accessing 7th element in an array of
            // size 5
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            Object[] s = new String[4];
            s[0] = new Object[5];
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }
        try {
            Object obj = new Integer(100);
            System.out.println((String) obj);
        } catch (ClassCastException e) {
            exceptions.add(e);
        }
        try {
            int arrSize = -8;
            int[] myArray = new int[arrSize];
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }
        try {
            Class.forName("example.javacodegeeks.MyInvisibleClass");
        } catch (ClassNotFoundException e) {
            exceptions.add(e);
        }



    }
}
