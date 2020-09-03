package com.javarush.task.task39.task3910;

/*
isPowerOfThree
*/
public class Solution {

  public static void main(String[] args) {

  }

  public static boolean isPowerOfThree(int n) {
    float f = (float) Math.log(n) /
        (float) Math.log(3);

    return (f - (int) f) == 0.0;
  }
}
