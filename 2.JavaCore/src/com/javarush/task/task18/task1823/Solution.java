package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;

        while (!(fileName = reader.readLine()).equals("exit")) {
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
        }
        System.out.println(resultMap);
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName = null;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        @Override
        synchronized public void run() {
            try {
                FileInputStream fis = new FileInputStream(fileName);
                int[] counts = new int[255];
                int max = 0;

                while (fis.available() > 0) {
                    counts[fis.read()]++;
                }

                for (int i = 0; i < counts.length; i++) {
                    if (counts[i] > counts[max]) {
                        max = i;
                    }
                }

                resultMap.put(fileName, max);
                //System.out.println(resultMap);
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
