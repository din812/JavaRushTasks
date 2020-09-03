package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {

  private final Tablet tablet;
  protected List<Dish> dishes = new ArrayList<>();

  public Order(Tablet tablet) throws IOException {
    this.tablet = tablet;
    initDishes();
  }

  public List<Dish> getDishes() {
    return dishes;
  }

  public int getTotalCookingTime() {
    int duration = 0;
    for (Dish d : dishes) {
      duration += d.getDuration();
    }
    return duration;
  }

  public Tablet getTablet() {
    return tablet;
  }

  @Override
  public String toString() {
    if (dishes.isEmpty()) {
      return "";
    }
    StringBuilder builder = new StringBuilder();
    for (Dish d : dishes) {
      builder.append(d.name() + ", ");
    }
    builder.deleteCharAt(builder.length() - 1);
    builder.deleteCharAt(builder.length() - 1);
    //Your order: [Juice, Fish] of Tablet{number=5}
    return String.format("Your order: [%s] of %s", builder.toString(), tablet.toString());
  }

  public boolean isEmpty() {
    return dishes.size() == 0;
  }

  protected void initDishes() throws IOException {
    dishes = ConsoleHelper.getAllDishesForOrder();
  }
}