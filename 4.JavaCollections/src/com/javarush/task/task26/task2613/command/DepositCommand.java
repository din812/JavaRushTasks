package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import java.util.ResourceBundle;

class DepositCommand implements Command {

  private final ResourceBundle res = ResourceBundle
      .getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

  @Override
  public void execute() throws InterruptOperationException {
    CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory
        .getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());
    String[] test = ConsoleHelper.getValidTwoDigits(currencyManipulator.getCurrencyCode());

    ConsoleHelper.writeMessage(res.getString("before"));

    currencyManipulator.addAmount(Integer.parseInt(test[0]), Integer.parseInt(test[1]));

    ConsoleHelper.writeMessage(String
        .format(res.getString("success.format"), Integer.parseInt(test[0]),
            Integer.parseInt(test[1])));
  }
}
