package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
        // Создай 10 котов
        Cat suka = new Cat();
        Cat suka1 = new Cat();
        Cat suka2 = new Cat();
        Cat suka3 = new Cat();
        Cat suka4 = new Cat();
        Cat suka5 = new Cat();
        Cat suka6 = new Cat();
        Cat suka7 = new Cat();
        Cat suka8 = new Cat();
        Cat suka9 = new Cat();
        // Выведи значение переменной catCount
        System.out.println(Cat.catCount);
    }

    public static class Cat {
        // Создай статическую переменную catCount
        public static int catCount;
        // Создай конструктор
        public Cat () {
            catCount++;
        }
    }
}
