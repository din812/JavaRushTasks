package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(br.readLine());

        int data = fr.read();

        StringBuilder stringBuilder = new StringBuilder();

        while (data != -1) {
            stringBuilder.append((char) data);
            data = fr.read();
        }

        String[] strings = stringBuilder.toString().replaceAll("\\R", " ").split(" ");

        for (int i = 0; i < strings.length; i++) {
            for (int j = 1; j < strings.length; j++) {
                if (i != j & strings[i] != null & strings[j] != null & (strings[i] != null && strings[i].equals(strings[j]))) {
                    Pair pair = new Pair();
                    pair.first = strings[i];
                    pair.second = strings[j];
                    result.add(pair);
                    System.out.println(pair);
                    strings[i] = null;
                    strings[j] = null;
                } else if (i != j & strings[i] != null & strings[j] != null) {
                    StringBuilder strBuilderI = new StringBuilder(strings[i]);

                    if (strBuilderI.reverse().toString().equals(strings[j])) {
                        Pair pair = new Pair();
                        pair.first = strings[i];
                        pair.second = strings[j];
                        result.add(pair);
                        System.out.println(pair);
                        strings[i] = null;
                        strings[j] = null;
                    }
                }
            }
        }

        //System.out.println(result.toString());
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
