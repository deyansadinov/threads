package com.clouway.timeout;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class TimeoutHashTable<K, V extends Number> {
  private final TimeoutInterval<K, V> timeoutInterval;
  private Map<K, V> threads = new Hashtable<K, V>();
  private Thread currentThread;

  public TimeoutHashTable(TimeoutInterval timeoutInterval) {
    this.timeoutInterval = timeoutInterval;
  }

  public void put(K key, V currentTime) {
    threads.put(key, currentTime);
    long lastUsed = threads.get(key).longValue();

    currentThread = new Thread(new ThreadCreator(timeoutIntervalOf(key), lastUsed));
    currentThread.start();
  }

  public V get(K key) {
    if (threads.containsKey(key)) {
      long timeDiff = new Date().getTime() - threads.get(key).longValue();
      long timeToSeconds = TimeUnit.MILLISECONDS.toSeconds(timeDiff);

      if (timeToSeconds > timeoutIntervalOf(key)) {
        threads.remove(key);
        throw new TimeOutOverflowException();
      }
    }
    
    return threads.get(key);
  }

  public void remove(K key) {
    threads.remove(key);
  }

  private Long timeoutIntervalOf(K key) {
    return timeoutInterval.get(key).longValue();
  }
}
