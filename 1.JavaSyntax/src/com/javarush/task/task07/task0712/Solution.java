package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        ArrayList<String> arrayMax = new ArrayList<>();
        ArrayList<String> arrayMin = new ArrayList<>();
        arrayMax.add(list.get(0));
        arrayMin.add(list.get(0));
        for (String s : list) {
            if (s.length() >= arrayMax.get(0).length()) {
                if (s.length() == arrayMax.get(0).length()) {
                    arrayMax.add(s);
                } else {
                    arrayMax.clear();
                    arrayMax.add(s);
                }
            } else if (s.length() <= arrayMin.get(0).length()) {
                if (s.length() == arrayMin.get(0).length()) {
                    arrayMin.add(s);
                } else {
                    arrayMin.clear();
                    arrayMin.add(s);
                }
            }
        }
        for (String s : list) {
            if (s.equals(arrayMax.get(0))) {
                System.out.println(arrayMax.get(0));
                break;
            } else if (s.equals(arrayMin.get(0))) {
                System.out.println(arrayMin.get(0));
                break;
            }
        }
    }
}
