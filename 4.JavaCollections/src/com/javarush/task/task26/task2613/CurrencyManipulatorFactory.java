package com.javarush.task.task26.task2613;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CurrencyManipulatorFactory {

  private static final Map<String, CurrencyManipulator> map = new HashMap<>();

  private CurrencyManipulatorFactory() {
  }

  public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
    if (!map.containsKey(currencyCode.toUpperCase())) {
      map.put(currencyCode.toUpperCase(), new CurrencyManipulator(currencyCode));
    }

    return map.get(currencyCode.toUpperCase());
  }

  public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
    return new ArrayList<>(map.values());
  }
}
