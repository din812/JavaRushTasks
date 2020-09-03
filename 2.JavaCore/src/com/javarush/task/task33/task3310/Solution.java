package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.DualHashBidiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.FileStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;
import com.javarush.task.task33.task3310.tests.SpeedTest;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    StorageStrategy strategy1 = new HashMapStorageStrategy();
    testStrategy(strategy1, 10000);
    StorageStrategy strategy2 = new OurHashMapStorageStrategy();
    testStrategy(strategy2, 10000);
    StorageStrategy strategy3 = new FileStorageStrategy();
    testStrategy(strategy3, 100);
    StorageStrategy strategy4=new OurHashBiMapStorageStrategy();
    testStrategy(strategy4, 10000);
    StorageStrategy strategy5=new HashBiMapStorageStrategy();
    testStrategy(strategy5, 10000);
    StorageStrategy strategy6=new DualHashBidiMapStorageStrategy();
    testStrategy(strategy6, 10000);
    new SpeedTest().testHashMapStorage();

  }

  public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
    Set<Long> identifications = new HashSet<Long>();
    for (String str :
        strings) {
      identifications.add(shortener.getId(str));
    }

    return identifications;
  }

  public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
    Set<String> strings = new HashSet<String>();
    for (Long ids :
        keys) {
      strings.add(shortener.getString(ids));
    }

    return strings;
  }

  public static void testStrategy(StorageStrategy storageStrategy, long elementsNumber) {
    Helper.printMessage(storageStrategy.getClass().getSimpleName());

    Set<String> strs = new HashSet<String>();
    Set<Long> keys = new HashSet<Long>();

    for (long i = 0; i < elementsNumber; i++) {
      strs.add(Helper.generateRandomString());
    }
    Shortener shortener = new Shortener(storageStrategy);

    Date startTime = new Date();

    keys = getIds(shortener, strs);

    Date stopTime = new Date();
    long elapsedTime = stopTime.getTime() - startTime.getTime();
    System.out.println(elapsedTime);

    Date startTime1 = new Date();

    Set<String> strings = getStrings(shortener, keys);

    Date stopTime1 = new Date();
    long elapsedTime1 = stopTime1.getTime() - startTime1.getTime();
    System.out.println(elapsedTime1);

    if (strs.equals(strings)) {
      Helper.printMessage("Тест пройден.");
    } else {
      Helper.printMessage("Тест не пройден.");
    }
  }
}
