package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;


public class CachingProxyRetriever implements Retriever{
  private Storage storage;
  private OriginalRetriever originalRetriever;
  private LRUCache lruCache;

  public CachingProxyRetriever (Storage storage) {
    this.storage = storage;
    this.originalRetriever = new OriginalRetriever(this.storage);
    this.lruCache = new LRUCache(5);
  }

  @Override
  public Object retrieve(long id) {
    Object o;

    if ((o = lruCache.find(id)) == null) {
      o = originalRetriever.retrieve(id);
      lruCache.set(id, o);
    }

    return o;
  }
}
