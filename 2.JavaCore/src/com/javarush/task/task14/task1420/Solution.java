package com.javarush.task.task14.task1420;

/* 
НОД
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


            int first = Integer.parseInt(reader.readLine());
            int second = Integer.parseInt(reader.readLine());
            int nod = Integer.min(first, second);


            if (first > 0 && second > 0){
                while (!(((first % nod) == 0) && ((second % nod) == 0))){
                    nod -= 1;
                }
                System.out.println(nod);
            }
            else {
                throw new Exception();
            }
    }
}
