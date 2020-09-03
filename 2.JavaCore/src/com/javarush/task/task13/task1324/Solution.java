package com.javarush.task.task13.task1324;

/* 
Один метод в классе
*/

import java.awt.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        static Color getColor(){
            return Color.cyan;
        }

        static Integer getAge(){
            return 5;
        }
    }

    public static class Fox implements Animal{
        public String getName() {
            return "Fox";
        }
    }
}
