package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2) {

                    }
                }
            }
        };
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        };
        thread.start();
        thread1.start();
        Thread.sleep(2000);


        return thread1.getState() != Thread.State.BLOCKED;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
