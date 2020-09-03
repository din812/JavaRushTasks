package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> integers = new ArrayList<>();
        int count = 1;
        int countStreak = 1;
        for (int i = 0; i < 10; ++i) {
            integers.add(Integer.parseInt(reader.readLine()));
            if (i == 0){
            }
            else if (integers.get(i-1).equals(integers.get(i))){
                count++;
                //if (count == 2){
                //   count++;
                //}
                if (countStreak < count){
                    countStreak = count;
                }
            }
            else {
                count = 1;
            }
        }
        System.out.println(countStreak);
    }
}