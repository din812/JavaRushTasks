package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;
    private Thread.State state;


    public LoggingStateThread(Thread target) {
        this.target = target;
        this.state = target.getState();
    }

    @Override
    public void run() {
        System.out.println(state);
        while (true) {
            if (state != target.getState()) {
                state = target.getState();
                System.out.println(state);
            }

            if (state == State.TERMINATED) {
                break;
            }
        }
        interrupt();
    }
}
