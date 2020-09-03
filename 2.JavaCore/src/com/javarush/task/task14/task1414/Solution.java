package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String key;

        ArrayList<String> keys = new ArrayList<String>();

        while (true){
                key = reader.readLine();
                keys.add(key);
                if (!key.matches("soapOpera|cartoon|thriller")){
                    break;
                }
        }

        for (String keysLoop: keys) {
            MovieFactory.getMovie(keysLoop);
        }


        //System.out.println(keys);
        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
                System.out.println(movie.getClass().getSimpleName());
            }

            //напишите тут ваш код, пункты 5,6
            else if ("cartoon".equals(key)) {
                movie = new Cartoon();
                System.out.println(movie.getClass().getSimpleName());
            }
            else if ("thriller".equals(key)) {
                movie = new Thriller();
                System.out.println(movie.getClass().getSimpleName());
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    //Напишите тут ваши классы, пункт 3

    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }
}
