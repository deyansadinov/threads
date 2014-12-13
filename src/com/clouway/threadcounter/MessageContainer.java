package com.clouway.threadcounter;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class MessageContainer implements Runnable {
  private int secondCounter = 0;

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      try {
        Thread.sleep(1000);
        secondCounter++;
      } catch (InterruptedException e) {

        return;
      }
    }
  }

  public int getSecondCounter() {
    return secondCounter;
  }

}
