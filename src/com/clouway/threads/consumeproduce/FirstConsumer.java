package com.clouway.threads.consumeproduce;

import static java.lang.Thread.sleep;

/**
 * Created by clouway on 14-10-30.
 */
public class FirstConsumer implements Activity {

  private ConcurrentValue cValue;

  public FirstConsumer(ConcurrentValue cValue) {
    this.cValue = cValue;
  }

  @Override
  public void execute(Sleeper sleeper) {
    for (int i = cValue.takeValueFirst(); cValue.isActive() ; i = cValue.takeValueFirst()) {
      System.out.format("%s: %d%n", Thread.currentThread().getName(), i);
      sleeper.sleepAWhile();
    }
  }


}
