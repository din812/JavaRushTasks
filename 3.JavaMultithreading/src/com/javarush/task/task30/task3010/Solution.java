package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {

  public static void main(String[] args) throws Exception{
    //напишите тут ваш код
    try {

      if (!args[0].matches("\\w*")) {
        System.out.println("incorrect");
      } else {
        for (int i = 2; i <= 36; i++) {
          try {
            BigDecimal bi = new BigDecimal(new BigInteger(args[0], i));
            System.out.println(i);
            break;
          } catch (Exception e) {

          }
        }
      }
    } catch (Exception e) {
    }
  }
}