package com.javarush.task.task04.task0441;
/* 
Как-то средненько
*/

import java.io.*;
import java.util.*;

import static java.lang.Integer.min;
import static java.lang.Math.max;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt((reader.readLine()));
        int number2 = Integer.parseInt((reader.readLine()));
        int number3 = Integer.parseInt((reader.readLine()));
        if (number1 == number2 && number1 == number3){
            System.out.println(number1);
        }
        else if (number1 == number2 || number1 == number3 || number2 == number3){
            System.out.println(number1==number2?number1:number3);
        }
        else {
            int median = max(min(number1,number2), min(max(number1,number2),number3));
            System.out.println(median);
        }
    }
}
