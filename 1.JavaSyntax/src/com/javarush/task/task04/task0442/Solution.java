package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int numberr = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int number = Integer.parseInt((reader.readLine()));
            numberr += number;
            if (number == -1) {
                break;
            }
        }
        System.out.println(numberr);
    }
}
