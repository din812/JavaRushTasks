package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.*;



public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt((reader.readLine()));
        int b = Integer.parseInt((reader.readLine()));
        int c = Integer.parseInt((reader.readLine()));
        Integer d [] = {a, b ,c};
        Arrays.sort(d, Collections.reverseOrder());
        for (int x = 0; x < d.length; x++)
            System.out.print(d[x] + " ");
    }
}