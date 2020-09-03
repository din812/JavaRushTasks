package com.javarush.task.task39.task3904;

/* 
Лестница
*/
public class Solution {

  private static final int n = 70;

  public static void main(String[] args) {
    System.out.println(
        "The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
  }

  public static long numberOfPossibleAscents(int n) {
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    if (n == 3) {
      return 4;
    }

    long i = 4, sum_fib = 1, a = 1, b = 2, c = 4;
    while (i++ <= n) {
      sum_fib = a + b + c;
      a = b;
      b = c;
      c = sum_fib;
    }
    return sum_fib;

  }
}

