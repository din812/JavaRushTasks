package com.javarush.task.task40.task4011;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* 
Свойства URL
*/

public class Solution {

  public static void main(String[] args) throws IOException {
    decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
  }

  public static void decodeURLString(String s) throws MalformedURLException {
    try {
      URL connection = new URL(s);

      System.out.println(connection.getProtocol());
      System.out.println(connection.getAuthority());
      System.out.println(connection.getFile());
      System.out.println(connection.getHost());
      System.out.println(connection.getPath());
      System.out.println(connection.getPort());
      System.out.println(connection.getDefaultPort());
      System.out.println(connection.getQuery());
      System.out.println(connection.getRef());
    } catch (MalformedURLException e) {
      System.out.println(String.format("Parameter %s is not a valid URL.", s));
    }
  }
}

