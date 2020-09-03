package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {

  private static int numberA;
  private static int numberB;

  public static String aBiggerThanB(int a, int b) {
    return getAllNumbersBetween(a, b);
  }

  public static String bBiggerThanA(int a, int b) {
    return getAllNumbersBetween(a, b);
  }

  public static String getAllNumbersBetween(int a, int b) {
    if (a > b) {
      return a + " " +  aBiggerThanB(a - 1, b);
    } else {
      if (a == b) {
        return Integer.toString(a);
      }
      return a + " " + bBiggerThanA(a + 1, b);
    }
  }

  public static void main(String[] args) {
    Random random = new Random();
    numberA = random.nextInt(1000);
    numberB = random.nextInt(1000);
    System.out.println(getAllNumbersBetween(numberA, numberB));
    System.out.println(getAllNumbersBetween(numberB, numberA));
  }
}