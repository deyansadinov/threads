package com.clouway.threads.consumeproduce;

import static java.lang.Thread.sleep;

/**
 * Created by clouway on 14-10-31.
 */
public class SecondConsumer implements Activity {

  private final ConcurrentValue cValue;

  public SecondConsumer(ConcurrentValue cValue) {
    this.cValue = cValue;
  }

  @Override
  public void execute(Sleeper sleeper) {
    for (int i = cValue.takeValueSecond(); cValue.isActive() ; i = cValue.takeValueSecond()) {
      System.out.format("%s: %d%n", Thread.currentThread().getName(), i);
      sleeper.sleepAWhile();
    }
  }


}
