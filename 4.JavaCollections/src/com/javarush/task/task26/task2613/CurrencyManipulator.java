package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CurrencyManipulator {

  private final String currencyCode;
  private Map<Integer, Integer> denominations = new TreeMap<>((o1, o2) -> o2 - o1);

  public CurrencyManipulator(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void addAmount(int denomination, int count) {
    denominations.merge(denomination, count, Integer::sum);
  }

  public boolean hasMoney() {
    return getTotalAmount() > 0 || !denominations.isEmpty();
  }

  public int getTotalAmount() {
    int result = 0;

    for (Entry<Integer, Integer> num :
        denominations.entrySet()) {
      result += num.getKey() * num.getValue();
    }

    return result;
  }

  public boolean isAmountAvailable(int expectedAmount) {
    return getTotalAmount() >= expectedAmount;
  }

  public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
    TreeMap<Integer, Integer> result = new TreeMap<>();

    for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
      int nominal = entry.getKey();
      int count = entry.getValue();
      if (expectedAmount >= nominal) {
        int k = expectedAmount / nominal;
        if (k <= count) {
          result.put(nominal, k);
          expectedAmount -= k * nominal;
        } else {
          throw new NotEnoughMoneyException();
        }
      }
      if (expectedAmount == 0) {
        break;
      }
    }
    if (expectedAmount == 0) {
      for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
        int nominal = entry.getKey();
        int count = denominations.get(nominal);
        count -= entry.getValue();
        denominations.put(nominal, count);
      }
      return result;
    } else {
      throw new NotEnoughMoneyException();
    }
  }
}
