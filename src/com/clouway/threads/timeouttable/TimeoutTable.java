package com.clouway.threads.timeouttable;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

/**
 * Created by clouway on 14-11-17.
 */
public class TimeoutTable<K,V> {

  private Map<K, Remover> table = new HashMap<K, Remover>();
  private int timeout;

  private class Remover<K,V> implements Runnable {

    private final K key;
    private int timeout;
    private final V value;


    private Remover(K key, int timeout, V value) {
      this.key = key;
      this.timeout = timeout;
      this.value = value;
    }

    @Override
    public void run() {
      try {
        while (timeout-- > 0) {
          sleep(1000);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      table.remove(key);
      System.out.println("Removing " + key);
    }


    public synchronized void setTimeout(int timeout) {
      this.timeout = timeout;
    }
  }

  public TimeoutTable(int timeout) {
    this.timeout = timeout;
  }

  public void put(K key, V value) {
    if (resetTimeoutIfExisting(key)) return;
    Remover remover = new Remover(key, timeout, value);
    table.put(key, remover);
    new Thread(remover).start();
  }

  public Object get(K key) {
    if(resetTimeoutIfExisting(key)){
      return table.get(key);
    }
    return null;
  }

  private boolean resetTimeoutIfExisting(K key) {
    if (table.containsKey(key)) {
      table.get(key).setTimeout(timeout);
      return true;
    }
    return false;
  }

}
