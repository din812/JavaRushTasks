package com.javarush.task.task27.task2712.ad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticAdvertisementManager {

  private static final StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
  private static final AdvertisementStorage storage = AdvertisementStorage.getInstance();

  private StatisticAdvertisementManager() {
  }

  public static StatisticAdvertisementManager getInstance() {
    return ourInstance;
  }

  public Map<String, Integer> getActiveVideos() {
    Map<String, Integer> result = new HashMap<>();
    List<Advertisement> videos = storage.list();

    for (Advertisement a : videos) {
      if (a.getHits() > 0) {
        result.put(a.getName(), a.getHits());
      }
    }

    return result;
  }

  public Map<String, Integer> getArchivedVideos() {
    Map<String, Integer> result = new HashMap<>();
    List<Advertisement> videos = storage.list();

    for (Advertisement a : videos) {
      if (a.getHits() <= 0) {
        result.put(a.getName(), a.getHits());
      }
    }

    return result;
  }
}
