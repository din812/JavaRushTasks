package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        /*String name = "Иванов Иван Иванович 13 09 1993";

        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(name));

        System.out.println(adapter.read());*/
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String line = fileScanner.nextLine();
            String[] arr = line.split("\\s", 4);
            SimpleDateFormat date = new SimpleDateFormat("dd M y");
            Date date1 = date.parse(arr[3]);
            return new Person(arr[1], arr[2], arr[0], date1);
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
