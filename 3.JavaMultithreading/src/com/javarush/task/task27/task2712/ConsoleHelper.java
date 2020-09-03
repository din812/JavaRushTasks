package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
  private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public static void writeMessage(String message) {
    System.out.println(message);
  }

  public static String readString() {
    String res = "";
    try {
      res = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return res;
  }

  public static List<Dish> getAllDishesForOrder() {
    List<Dish> listRes = new ArrayList<>();
    Dish[] dishes = Dish.values();
    for (Dish d : dishes) {
      System.out.println(d.name());
    }
    boolean fExit = false;
    System.out.println("Для закрытия меню введите: exit");
    while (!fExit) {
      String input = readString();
      if (input.equals("exit")) {
        fExit = true;
        continue;
      }
      Dish dish = null;
      try {
        dish = Dish.valueOf(input);
      } catch (IllegalArgumentException e) {
        System.out.println("Данного пункта нет в меню" + input);
        continue;
      }
      listRes.add(dish);
    }
    return listRes;
  }
}