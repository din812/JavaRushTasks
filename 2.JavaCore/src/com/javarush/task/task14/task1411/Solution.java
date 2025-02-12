package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        List<String> keys = Arrays.asList("user", "loser", "coder", "proger");


        //тут цикл по чтению ключей, пункт 1
        while (keys.contains(key = reader.readLine())){
            //создаем объект, пункт 2
            switch (key){
                case "user" : doWork(new Person.User()); break;
                case "loser" : doWork(new Person.Loser()); break;
                case "coder" : doWork(new Person.Coder()); break;
                case "proger" : doWork(new Person.Proger()); break;
            }
            //doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User){
            ((Person.User) person).live();
        }
        if (person instanceof Person.Loser){
            ((Person.Loser) person).doNothing();
        }
        if (person instanceof Person.Coder){
            ((Person.Coder) person).writeCode();
        }
        if (person instanceof Person.Proger){
            ((Person.Proger) person).enjoy();
        }
    }

}
