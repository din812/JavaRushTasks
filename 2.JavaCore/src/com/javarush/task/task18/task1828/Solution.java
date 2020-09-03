package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        String line = null;
        ArrayList<Integer> ids = new ArrayList<>();

        if (args[0].equals("-u")) {
            BufferedReader filereader = new BufferedReader(new FileReader(filename));

            String idNewMax = String.format("%1$-8s", args[1]);
            String productName = String.format("%1$-30s", args[2]);
            String price = String.format("%1$-8s", args[3]);
            String quantity = String.format("%1$-4s", args[4]);

            //System.out.println(idNewMax + productName + price + quantity);
            Path path = Paths.get(filename);
            long lineCount = Files.lines(path).count();
            String[] lines = new String[(int) lineCount];
            int i = 0;
            while ((line = filereader.readLine()) != null) {
                lines[i] = line;
                i++;
            }

            for (int j = 0; j < lines.length; j++) {
                lines[j] = lines[j].replaceAll(args[1]+".*", idNewMax + productName + price + quantity);
            }

            reader.close();
            filereader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (int j = 0; j < lines.length; j++) {
                writer.write(lines[j]+"\r");
            }
            writer.close();
        }
        if (args[0].equals("-d")) {
            BufferedReader filereader = new BufferedReader(new FileReader(filename));

            String idNewMax = String.format("%1$-8s", args[1]);

            Path path = Paths.get(filename);
            long lineCount = Files.lines(path).count();
            String[] lines = new String[(int) lineCount];
            int i = 0;
            while ((line = filereader.readLine()) != null) {
                lines[i] = line;
                i++;
            }

            for (int j = 0; j < lines.length; j++) {
                lines[j] = lines[j].replaceAll(args[1]+".*", "");
            }

            reader.close();
            filereader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (int j = 0; j < lines.length; j++) {
                if (!lines[j].equals("")) {
                    writer.write(lines[j] + "\r");
                }
            }
            writer.close();
        }
    }
}
