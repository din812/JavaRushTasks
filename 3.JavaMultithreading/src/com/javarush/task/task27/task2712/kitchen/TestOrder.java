package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {
    
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        dishes = new ArrayList<>();

        int valueDishes = (int) (Math.random() * 10);

        for (int i = 0; i < valueDishes; i++) {
            int num = (int) (Math.random() * Dish.values().length);
            dishes.add(Dish.values()[num]);
        }
    }
}
