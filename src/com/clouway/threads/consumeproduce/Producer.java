package com.clouway.threads.consumeproduce;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by clouway on 14-10-30.
 */
public class Producer implements Activity {

  private final ConcurrentValue cValue;
  private final int[] array;

  public Producer(ConcurrentValue cValue, int[] array) {
    this.cValue = cValue;
    this.array = array;
  }

  @Override
  public void execute(Sleeper sleeper) {
    for (int each : array) {
      cValue.putValue(each);
      sleeper.sleepAWhile();
    }
    cValue.stop();
  }

}
