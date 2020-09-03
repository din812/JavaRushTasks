package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt((reader.readLine()));
        int c1 = 1;
        int n2 = Integer.parseInt((reader.readLine()));
        int c2 = 2;
        int n3 = Integer.parseInt((reader.readLine()));
        int c3 = 3;
        if (n1 == n2 && n1 != n3){
            System.out.println(c3);
        }
        else if (n1 == n3 && n1 != n2){
            System.out.println(c2);
        }
        else if (n2 == n3 && n2 != n1){
            System.out.println(c1);
        }
    }
}
