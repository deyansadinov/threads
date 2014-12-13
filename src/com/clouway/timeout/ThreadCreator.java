package com.clouway.timeout;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class ThreadCreator<T extends Number> extends Thread {
  private T timeLimit;
  private final long lastUsed;
  private Map<String, Long> threads = new Hashtable<String, Long>();

  public ThreadCreator(T timeLimit, long lastUsed) {
    this.timeLimit = timeLimit;
    this.lastUsed = lastUsed;
  }
}
