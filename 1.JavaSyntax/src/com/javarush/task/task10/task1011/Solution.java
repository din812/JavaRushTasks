package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        String subString = s;
        System.out.println(subString);
        while (!subString.equals("зарплату")){
            for (;;){
                subString = subString.substring(1);
                System.out.println(subString);
                if (subString.equals("зарплату")){
                    break;
                }
            }
        }
        //напишите тут ваш код
    }

}

