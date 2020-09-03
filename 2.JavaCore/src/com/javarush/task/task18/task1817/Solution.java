package com.javarush.task.task18.task1817;

/* 
Пробелы
*/


import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);  //Instantiate the FileInputStream class by passing an object of the required file as parameter to its constructor.
        //BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        ArrayList<Byte> list = new ArrayList<Byte>();
        //ArrayList<String> list1 = new ArrayList<String>();

        while (fileInputStream.available() > 0) {
            list.add((byte) fileInputStream.read());
        }

        int chars = 0;
        int whitespaceCount = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 32) {
                whitespaceCount++;
            } else {
                chars++;
            }
        }

        chars += whitespaceCount;

        //while (reader.read() > 0) {
        //    list1.add(reader.readLine());
        //}

        double value =(whitespaceCount/(double) chars)*100;
        DecimalFormat df = new DecimalFormat("####0.00");
        System.out.println(df.format(value));
        fileInputStream.close();
        //reader.close();



        double count = 0;
        double countSpace = 0;
        FileInputStream in = new FileInputStream(args[0]);
        while ((in.available() > 0)) {
            char c = (char) in.read();
            count++;

            if (c == ' ') countSpace++;
        }
        System.out.println(countSpace);
        System.out.println(count);
        double d =  countSpace/ count *100;
        System.out.println(Math.round(d*100)/(double)100);
        in.close();
    }
}
