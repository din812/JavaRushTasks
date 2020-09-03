package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticsManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {


  public void printAdvertisementProfit() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    double totalAmount = 0;
    for (Map.Entry<Date, Double> profitOfDay : StatisticsManager.getInstance()
        .getAdvertisementProfit().entrySet()) {
      Date date = profitOfDay.getKey();
      Double amount = profitOfDay.getValue();
      totalAmount += amount;
      ConsoleHelper
          .writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", sdf.format(date), amount));
    }
    ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", totalAmount));

  }

  public void printCookWorkloading() {
    Map<Date, TreeMap<String, Integer>> map = StatisticsManager.getInstance().getCookWorkloading();
    List<Date> list = new ArrayList<>(map.keySet());
    Collections.sort(list);
    Collections.reverse(list);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    for (Date date : list) {
      ConsoleHelper.writeMessage(dateFormat.format(date));
      Map<String, Integer> mapSI = map.get(date);
      List<String> stringList = new ArrayList<>(mapSI.keySet());
      Collections.sort(stringList);
      for (String name : stringList) {
        ConsoleHelper.writeMessage(name + " - " + (int) Math.ceil(mapSI.get(name)) + " min");
      }
      ConsoleHelper.writeMessage("");
    }

  }

  public void printActiveVideoSet() {
    Map<String, Integer> videos = StatisticAdvertisementManager.getInstance().getActiveVideos();
    List<String> list = new ArrayList<>(videos.keySet());
    Collections.sort(list);
    for (String s : list) {
      ConsoleHelper.writeMessage(String.format("%s - %d", s, videos.get(s)));
    }
  }

  public void printArchivedVideoSet() {
    Map<String, Integer> videos = StatisticAdvertisementManager.getInstance().getArchivedVideos();
    List<String> list = new ArrayList<>(videos.keySet());
    list.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
      }
    });
    for (String s : list) {
      ConsoleHelper.writeMessage(String.format("%s - %d", s, videos.get(s)));
    }
  }
}
