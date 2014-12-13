package com.clouway.threads.dependent;

import static java.lang.Thread.sleep;

/**
 * Created by clouway on 14-10-30.
 */
public class ThreadCounter implements Runnable {

  private int countTo;
  private ThreadCounter other;

  public ThreadCounter(int countTo) {
    this.countTo = countTo;
  }

  public void waitFor(ThreadCounter other) {
    this.other = other;
  }

  @Override
  public void run() {
      for (int i = 0; i < countTo; i++) {
        try {
          System.out.format("Elapsed: %d,sec.%n", i);
          sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      other.countTo = countTo;
  }
}
