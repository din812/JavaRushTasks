package com.javarush.task.task12.task1225;

/* 
Посетители
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код

//        switch (o.getClass().getSimpleName()) {
//            case Cat : return "Кот";
//            case Tiger : return "Тигр";
//            case Lion : return "Лев";
//            case Bull : return "Бык";
//            case Cow : return "Корова";
//            case Animal : return "Животное";
//        }


        return o.toString();
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
        @Override
        public String toString() {
            return "Кот";
        }
    }

    public static class Tiger extends Cat {
        @Override
        public String toString() {
            return "Тигр";
        }
    }

    public static class Lion extends Cat {
        @Override
        public String toString() {
            return "Лев";
        }
    }

    public static class Bull extends Animal {
        @Override
        public String toString() {
            return "Бык";
        }
    }

    public static class Cow extends Animal {
        @Override
        public String toString() {
            return "Корова";
        }
    }

    public static class Animal {
        @Override
        public String toString() {
            return "Животное";
        }
    }
}
