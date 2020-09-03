package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double time = Double.parseDouble((reader.readLine()));
        Math.round(time);
        time %= 5;
        if (time >= 0 && time < 3){
            System.out.println("зелёный");
        }
        else if (time>=3 && time < 4){
            System.out.println("жёлтый");
        }
        else {
            System.out.println("красный");
        }
    }
}