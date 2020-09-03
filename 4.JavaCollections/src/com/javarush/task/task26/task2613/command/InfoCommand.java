package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import java.util.ResourceBundle;

class InfoCommand implements Command {

  private final ResourceBundle res = ResourceBundle
      .getBundle(CashMachine.RESOURCE_PATH + "info_en");

  @Override
  public void execute() {
    ConsoleHelper.writeMessage(res.getString("before"));
    if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty()) {
      ConsoleHelper.writeMessage(res.getString("no.money"));
      return;
    }

    for (CurrencyManipulator man :
        CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
      ConsoleHelper
          .writeMessage(man.hasMoney() ? String
              .format("%s - %d", man.getCurrencyCode(), man.getTotalAmount())
              : res.getString("no.money"));
    }
  }
}
