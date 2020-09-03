package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream bFileReader = new FileInputStream(args[0]);
             FileOutputStream fileOutputStream = new FileOutputStream(args[1])) {

            Charset utf8 = Charset.forName("UTF-8");
            Charset windows1251 = Charset.forName("Windows-1251");

            byte[] buff = Files.readAllBytes(Paths.get(args[0]));
            String str = new String(buff,windows1251);
            buff = str.getBytes(utf8);
            FileOutputStream fos = new FileOutputStream(args[1]);
            fos.write(buff);
        }
    }
}
