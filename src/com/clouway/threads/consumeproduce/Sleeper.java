package com.clouway.threads.consumeproduce;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by clouway on 14-10-31.
 */
public class Sleeper {

  private int sleepTime;

  public Sleeper(int sleepTime) {
    this.sleepTime = sleepTime;
  }

  public void sleepAWhile() {
    Random random = new Random();
    try {
      sleep(random.nextInt(sleepTime));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
