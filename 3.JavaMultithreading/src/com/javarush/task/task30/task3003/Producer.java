package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
  private TransferQueue<ShareItem> queue;

  public Producer(TransferQueue<ShareItem> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 9; i++) {
      System.out.format("Элемент 'ShareItem-%d' добавлен\n", i);
      queue.offer(new ShareItem("ShareItem-" + i, i));
      try {
        Thread.sleep(100);
        if (queue.hasWaitingConsumer()) {
          System.out.format("Consumer в ожидании!\n");
        }
      } catch (InterruptedException e) {
        break;
      }
      if (Thread.currentThread().isInterrupted()) {
        break;
      }
    }

  }
}