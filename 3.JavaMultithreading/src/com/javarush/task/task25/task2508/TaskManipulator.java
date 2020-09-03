package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread taskThread;



    @Override
    public void run() {
        //System.out.println(taskThread.getName());
        while (!taskThread.isInterrupted()) {
            try {
                System.out.println(taskThread.getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
        taskThread = new Thread(this, threadName);
        taskThread.start();
    }

    @Override
    public void stop() {
        taskThread.interrupt();
    }
}
