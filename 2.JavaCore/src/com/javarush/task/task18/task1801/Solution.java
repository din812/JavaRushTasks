package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        ArrayList<Byte> list = new ArrayList<>();

        while (inputStream.available() > 0) {
            list.add((byte) inputStream.read());
        }
        inputStream.close();
        Collections.sort(list);
        //Collections.reverse(list);
        System.out.println(list.get(list.size()-1));
    }
}
