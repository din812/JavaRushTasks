package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human father = new Human("pidor", true, 99);
        Human mother = new Human("suka", false, 99);

        Human h1 = new Human("huy", true, 69);
        Human h2 = new Human("huy2", true, 69);

        Human h5 = new Human("huy4", false, 69, father, mother);
        Human h6 = new Human("huy5", false, 69, father, mother);
        Human h7 = new Human("huy6", false, 669, father, mother);
        Human h8 = new Human("huy7", false, 639, father, mother);
        Human h9 = new Human("huy8", false, 649, father, mother);
        Human[] humans = {father, mother, h1, h2, h5, h6, h7, h8, h9};
        for (Human h:humans) {
            System.out.println(h);
        }
    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human (String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}