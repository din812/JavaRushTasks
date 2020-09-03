package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;
import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {

  private final ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

  @Override
  public void execute() throws InterruptOperationException {
    ConsoleHelper.writeMessage(res.getString("before"));
    String code = ConsoleHelper.askCurrencyCode();
    CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);

    int withdrawAmount;

    while (true) {
      ConsoleHelper.writeMessage(res.getString("specify.amount"));
      String amount = ConsoleHelper.readString();
      if (amount.matches("\\d+")) {
        withdrawAmount = Integer.parseInt(amount);
        if (manipulator.isAmountAvailable(withdrawAmount)) {
          try {

            for (Map.Entry<Integer, Integer> entry : manipulator.withdrawAmount(withdrawAmount)
                .entrySet()) {
              ConsoleHelper.writeMessage(
                  String.format(res.getString("success.format"), entry.getKey(), entry.getValue()));
            }

            break;
          } catch (NotEnoughMoneyException e) {
            ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            continue;
          }
        } else {
          ConsoleHelper.writeMessage(res.getString("not.enough.money"));
          continue;
        }
      }
      ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
    }
  }
}
