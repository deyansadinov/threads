package com.clouway.threads.consumeproduce;

/**
 * Created by clouway on 14-10-31.
 */
public class ConcurrentValue {

  public boolean firstEmpty = true;
  public boolean secondEmpty = true;
  private boolean active = true;
  private int value;

  public synchronized int takeValueFirst() {
    while (firstEmpty) {
      waitUntilNotify();
    }
    firstEmpty = true;
    notifyAll();
    return value;
  }

  public synchronized int takeValueSecond() {
    while (secondEmpty) {
      waitUntilNotify();
    }
    secondEmpty = true;
    notifyAll();
    return value;
  }

  public synchronized void putValue(int value) {
    while (!(firstEmpty && secondEmpty)) {
      waitUntilNotify();
    }
    firstEmpty = false;
    secondEmpty = false;
    this.value = value;
    notifyAll();
  }

  private void waitUntilNotify() {
    try {
      wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public synchronized void stop() {
    // Make sure there aren't threads waiting.
    firstEmpty = false;
    secondEmpty = false;
    notifyAll();

    this.active = false;
  }

  public synchronized boolean isActive() {
    return active;
  }

}
