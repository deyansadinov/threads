package com.clouway.timecounter;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class TimeCounter implements Runnable {
  private int secondCounter = 0;
  private boolean flag = true;

  @Override
  public void run() {

    for (int i = 0; i < 1000; i++) {
      while (flag) {
        try {
          Thread.sleep(1000);
          secondCounter++;
        } catch (InterruptedException e) {
          return;
        }
      }
    }
  }

  public int getSecondCounter() {
    return secondCounter;
  }

  public void changeFlag() {
    flag = false;
  }
}
