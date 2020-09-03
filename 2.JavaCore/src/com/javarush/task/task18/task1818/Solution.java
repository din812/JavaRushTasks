package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1, true);
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        FileInputStream fileInputStream3 = new FileInputStream(fileName3);

        /*int i;

        while((i=fileInputStream2.read())!= -1){

            System.out.print((char)i);
        }*/


        while (fileInputStream2.available() > 0){
            fileOutputStream1.write(fileInputStream2.read());
        }
        while (fileInputStream3.available() > 0){
            fileOutputStream1.write(fileInputStream3.read());
        }

        fileOutputStream1.close();
        fileInputStream2.close();
        fileInputStream3.close();
        reader.close();
    }
}
