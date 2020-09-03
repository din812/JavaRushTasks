package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends java.util.Observable implements Runnable {

  private final String name;
  private boolean busy;
  private LinkedBlockingQueue<Order> queue;

  public Cook(String name) {
    this.name = name;

  }

  public void startCookingOrder(Order order) {
    busy = true;

    ConsoleHelper.writeMessage(
        "Start cooking - " + order + ", cooking time " + (order.getTotalCookingTime() + "min"));

    CookedOrderEventDataRow eventDataRow = new CookedOrderEventDataRow(order.getTablet().toString(),
        name,
        order.getTotalCookingTime(), order.getDishes());
    StatisticManager.getInstance().register(eventDataRow);

    setChanged();
    notifyObservers(order);

    try {
      Thread.sleep(10 * order.getTotalCookingTime());
    } catch (InterruptedException ignored) {
    }

    busy = false;
  }

  public void setQueue(
      LinkedBlockingQueue<Order> queue) {
    this.queue = queue;
  }

  public boolean isBusy() {
    return busy;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public void run() {

    while (!Thread.currentThread().isInterrupted()) {
      if (!isBusy()) {
        if (queue.size() > 0) {
          try {
            startCookingOrder(queue.take());
          } catch (InterruptedException e) {

          }
        }
      }

      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}