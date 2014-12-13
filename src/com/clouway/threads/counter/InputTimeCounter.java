package com.clouway.threads.counter;

import static java.lang.Thread.sleep;

/**
 * Created by clouway on 14-10-30.
 */
public class InputTimeCounter implements Runnable {

  private int countUntil;

  public InputTimeCounter(int countUntil) {
    this.countUntil = countUntil;
  }

  @Override
  public void run() {
    for (int i = 0; i < countUntil; i++) {

      try {
        doSomething(); // 50ms

        sleep(1000);
      } catch (InterruptedException e) {
        System.out.format("Time until input: %d,sec.%n",i);
        return;
      }
      System.out.format("Elapsed: %d,sec.%n",i);
    }

  }

  private void doSomething() {

  }


}
