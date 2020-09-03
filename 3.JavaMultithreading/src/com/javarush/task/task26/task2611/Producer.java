package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;
    private int count = 0;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        while (true) {
            try {
                map.put(String.valueOf(++count), String.format("Some text for %d", count));
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
                break;
            }
        }
    }
}
