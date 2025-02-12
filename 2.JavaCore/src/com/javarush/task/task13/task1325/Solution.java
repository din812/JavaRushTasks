package com.javarush.task.task13.task1325;

/* 
Компиляция программы
*/

import java.awt.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Fox bigFox = new BigFox();
        System.out.println(bigFox.getName());
        System.out.println(Animal.getColor());
    }

    public interface Animal {
        static Color getColor(){
            return Color.magenta;
        }
    }

    public static abstract class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }

    public static class BigFox extends Fox{

    }

}
