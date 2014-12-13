package com.clouway.threads.thread5;

import java.util.Map;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TimeoutRemover extends Thread {
  private int counterStop;
  private boolean reset;
  private final String key;
  private final Map<String, Object> timeOutHashTable;
  long startTime = System.nanoTime();

  public TimeoutRemover(int counterStop, String key, Map<String, Object> timeOutHashTable) {
    this.counterStop = counterStop;
    this.key = key;
    this.timeOutHashTable = timeOutHashTable;
  }

  public void run() {
    int counter = counterStop;
    for (int i = 0; i < counterStop; i++) {
      if (reset) {
        counterStop += counter - i -1;
        reset = false;
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    timeOutHashTable.remove(key);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println(Thread.currentThread().getName() + " Time " + duration);
  }


  public void reset() {
    reset = true;
  }
}
