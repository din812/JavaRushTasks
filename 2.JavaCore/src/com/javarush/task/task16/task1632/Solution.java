package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
        threads.get(0).start();
        threads.get(1).start();
        threads.get(1).interrupt();
        threads.get(2).start();
        threads.get(3).start();
        threads.get(4).start();

    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                  throw new InterruptedException();
               } catch (InterruptedException e) {
                  System.out.println("InterruptedException");
              }
          }
        }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
               try {
                Thread1.sleep(500);
               } catch (InterruptedException e) {
                    e.printStackTrace();
               }
          }
        }
    }

    public static class Thread4 extends Thread implements Message {
        private static volatile boolean myBoolean = true;
        public void run() {
            while (myBoolean) {
            }
        }
        public void showWarning() {
            myBoolean = false;
        }
    }

    public static class Thread5 extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String currentLine;
            int count = 0;

            try {

                while (!(currentLine = reader.readLine()).equals("N")) {
                    count += Integer.parseInt(currentLine);
                }
                System.out.println(count);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}