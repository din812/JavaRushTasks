package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {

    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        return Arrays.toString(values()).replaceAll("\\[|\\]", "");
    }

    public static boolean contains(String e) {
        for (Dish d : values()) {
            if (d.name().equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int getDuration() {
        return duration;
    }
}
