package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
  private static final int ORDER_CREATING_INTERVAL = 100;

  private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

  public static void main(String[] args) {
    List<Tablet> tablets = new ArrayList<>();

    Cook cook1 = new Cook("Amigo");
    cook1.setQueue(orderQueue);
    Cook cook2 = new Cook("Pedro");
    cook2.setQueue(orderQueue);

    StatisticManager.getInstance().register(cook1);
    StatisticManager.getInstance().register(cook2);

    Waiter waiter = new Waiter();
    cook1.addObserver(waiter);
    cook2.addObserver(waiter);

    for (int i = 1; i <= 5; i++) {
      Tablet tablet = new Tablet(i);
      tablet.setQueue(orderQueue);
      tablets.add(tablet);
    }

    RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
    Thread cookThread = new Thread(randomOrderGeneratorTask);
    cookThread.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    cookThread.interrupt();

    DirectorTablet directorTablet = new DirectorTablet();
    directorTablet.printAdvertisementProfit();
    directorTablet.printCookWorkloading();
    directorTablet.printActiveVideoSet();
    directorTablet.printArchivedVideoSet();

  }

}