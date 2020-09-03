package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        String line = null;
        ArrayList<Integer> ids = new ArrayList<>();

        if ((args.length == 4) && args[0].equals("-c")) {
            int idLength = 8;
            int pnLength = 30;
            int priceLength = 8;
            int quantityLength = 4;
            int idMax = 0;

            BufferedReader filereader = new BufferedReader(new FileReader(filename));

            while ((line = filereader.readLine()) != null) {
                ids.add(Integer.parseInt(line.substring(0, 8).trim()));
            }
            Collections.sort(ids);
            idMax = (ids.get(ids.size()-1))+1;

            String idNewMax = String.format("%1$-8s", idMax);
            String productName = String.format("%1$-30s", args[1]);
            String price = String.format("%1$-8s", args[2]);
            String quantity = String.format("%1$-4s", args[3]);

            //System.out.println(idNewMax + productName + price + quantity);

            reader.close();
            filereader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.newLine();
            writer.write(idNewMax + productName + price + quantity);
            writer.close();
        }
    }
}
