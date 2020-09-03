package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));
        while (br.ready()) {
            allLines.add(br.readLine());
        }
        br.close();

        br = new BufferedReader(new FileReader(reader.readLine()));
        while (br.ready()) {
             forRemoveLines.add(br.readLine());
        }
        br.close();


        Solution joindata = new Solution();
        try {
            joindata.joinData();
        } catch (CorruptedDataException e) {
            //System.out.println("CorruptedData");
        }
        reader.close();
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
                allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
