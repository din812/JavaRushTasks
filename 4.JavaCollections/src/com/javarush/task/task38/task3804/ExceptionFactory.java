package com.javarush.task.task38.task3804;

public class ExceptionFactory {

  public static Throwable getException(Enum e) {
    if (e != null) {
      String mes = e.name().substring(0,1)+e.name().substring(1).toLowerCase().replace("_"," ");
      if (e instanceof ApplicationExceptionMessage) {
        return new Exception(mes);
      } else if (e instanceof DatabaseExceptionMessage) {
        return new RuntimeException(mes);
      } else if (e instanceof UserExceptionMessage) {
        return new Error(mes);
      }
    }
    return  new IllegalArgumentException();

  }
}
