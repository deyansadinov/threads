package com.clouway.timeout;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class TimeoutInterval<K, V extends Number> {
  private Map<K, V> timeoutInterval = new Hashtable<K, V>();

  public void put(K key, V value) {
    timeoutInterval.put(key, value);
  }

  public V get(K key) {
    return timeoutInterval.get(key);
  }

}
