package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;

        try {
            inputStream = new FileInputStream(reader.readLine());
            bufferedInputStream = new BufferedInputStream(inputStream);

            while (bufferedInputStream.available()>0){
                char c = (char)bufferedInputStream.read();

                System.out.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            assert inputStream != null;
            inputStream.close();
            assert bufferedInputStream != null;
            bufferedInputStream.close();
            reader.close();
        }

    }
}