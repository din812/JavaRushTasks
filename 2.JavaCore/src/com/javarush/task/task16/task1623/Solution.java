package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

import java.awt.*;

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        new GenerateThread();
    }

    public static class GenerateThread extends Thread{
        public GenerateThread() {
            super(String.valueOf(++createdThreadCount));
            start();
        }

        @Override
        public void run() {
            if (createdThreadCount < Solution.count) {
                //GenerateThread generateThread = new GenerateThread();
                System.out.println(new GenerateThread());
            }
        }

        @Override
        public String toString() {
            return getName() + " created";
        }
    }
}
