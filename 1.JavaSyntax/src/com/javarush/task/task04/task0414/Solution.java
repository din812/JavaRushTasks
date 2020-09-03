package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String year = reader.readLine();
        int yearInt = Integer.parseInt(year);
//        if ((yearInt%400)==0){
//            if ((yearInt%100)==0){
//                if ((yearInt%4)==0){
//                    System.out.println("количество дней в году: 366");
//                }
//                System.out.println("количество дней в году: 365");
//            }
//            System.out.println("количество дней в году: 366");
//        }
//        else {
//            System.out.println("количество дней в году: 365");
//        }
        if ((yearInt%400)==0){
            System.out.println("количество дней в году: 366");
        }
        else if ((yearInt%100)==0){
            System.out.println("количество дней в году: 365");
        }
        else if ((yearInt%4)==0){
            System.out.println("количество дней в году: 366");
        }
        else {
            System.out.println("количество дней в году: 365");
        }
    }
}