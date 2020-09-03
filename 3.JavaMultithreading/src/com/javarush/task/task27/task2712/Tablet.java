package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {

  private LinkedBlockingQueue<Order> queue;

  public static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());
  public final int number;

  public Tablet(int tabletNumber) {
    number = tabletNumber;
  }

  @Override
  public String toString() {
    return String.format("Tablet{number=%d}", number);
  }

  public Order createOrder(Order order) {
    if (order.isEmpty()) {
      return null;
    }
    AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
    System.out.println(order.toString());
    try {
      manager.processVideos();
    } catch (NoVideoAvailableException noVideoException) {
      logger.log(Level.INFO, "No video is available for the order " + order);
    }
    queue.offer(order);
    return order;
  }

  public void setQueue(
      LinkedBlockingQueue<Order> queue) {
    this.queue = queue;
  }

  public void createTestOrder() {
    try {
      TestOrder testOrder = new TestOrder(this);
      createOrder(testOrder);
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Console is unavailable.");
    }
  }
}