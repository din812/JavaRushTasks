package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int mediana;
        ArrayList<Integer> tmp =  new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            tmp.add(array[i]);
        }
        Collections.sort(tmp);

        if (array.length%2==0) {
            mediana = (tmp.get((array.length / 2 ) - 1) + tmp.get(array.length / 2)) / 2;
        } else {
            mediana = tmp.get(((array.length - 1) / 2));
        }

        Comparator<Integer> compareByMediana = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(mediana - o1) - Math.abs(mediana - o2);
            }
        };

        Collections.sort(tmp, compareByMediana);
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp.get(i);
        }

        return array;
    }
}
