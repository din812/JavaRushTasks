package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (!isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Got: " + value);
        notifyAll();
        isValuePresent = false;
        return value;
    }

    public synchronized void put(int value) {
        while (isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        System.out.println("Put: " + value);
        notifyAll();
        isValuePresent = true;
    }
}
