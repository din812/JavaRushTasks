package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(10.0, "Geeks");
        labels.put(15.0, "4");
        labels.put(20.0, "Geeks");
        labels.put(25.0, "Welcomes");
        labels.put(30.0, "You");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
