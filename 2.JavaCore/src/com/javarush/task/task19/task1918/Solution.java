package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));

        StringBuilder html = new StringBuilder();

        while (fileReader.ready()) {
            html.append(fileReader.readLine());
        }

        Document document = Jsoup.parse(html.toString(), " ", Parser.xmlParser());
        Elements h1 = document.select(args[0]);
        System.out.println(h1);

        reader.close();
        fileReader.close();
    }
}
