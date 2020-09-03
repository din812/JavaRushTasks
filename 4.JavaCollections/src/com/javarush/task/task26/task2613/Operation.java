package com.javarush.task.task26.task2613;

public enum Operation {
  LOGIN,
  INFO,
  DEPOSIT,
  WITHDRAW,
  EXIT;


  public static Operation getAllowableOperationByOrdinal(Integer i) {
    switch (i) {
      case 2:
        return INFO;
      case 3:
        return DEPOSIT;
      case 4:
        return WITHDRAW;
      case 5:
        return EXIT;
      default:
        throw new IllegalArgumentException();
    }
  }
}
