package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

  private static final BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
  private static final ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

  public static void writeMessage(String message) {
    System.out.println(message);
  }

  public static String readString() throws InterruptOperationException{
    try {
      String answer = bis.readLine();
      if (answer.equalsIgnoreCase("exit")) {
        writeMessage(res.getString("the.end"));
        throw new InterruptOperationException();
      }
      return answer;
    } catch (IOException e) {
      return readString();
    }
  }

  public static String askCurrencyCode() throws InterruptOperationException {
    writeMessage(res.getString("choose.currency.code"));
    String userInput = readString();
    while (userInput.length() != 3) {
      writeMessage(res.getString("invalid.data"));
      userInput = readString();
    }
    return userInput.toUpperCase();
  }

  public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
    writeMessage(res.getString("choose.denomination.and.count.format"));
    String[] s;
    while (true) {
      s = readString().split(" ");
      if (s.length == 2 && s[0].matches("\\d+") && s[1].matches("\\d+")
          && Integer.parseInt(s[0]) * Integer.parseInt(s[1]) > 0) {
        break;
      }
      writeMessage(res.getString("invalid.data"));
    }
    return s;
  }

  public static Operation askOperation() throws InterruptOperationException {
    try {
      writeMessage(res.getString("choose.operation"));
      writeMessage(res.getString("operation.INFO"));
      writeMessage(res.getString("operation.DEPOSIT"));
      writeMessage(res.getString("operation.WITHDRAW"));
      writeMessage(res.getString("operation.EXIT"));

      return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
    } catch (IllegalArgumentException e) {
      writeMessage(res.getString("choose.currency.code"));
      return askOperation();
    }
  }

  public static void printExitMessage() {
    writeMessage(res.getString("the.end"));
  }
}
