package com.clouway.fromtocounter;


import sun.misc.Lock;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class CounterThread implements Runnable, Comparable<CounterThread> {
  private int counter;
  private final int endCounter;
  private boolean stopper = true;


  public CounterThread(int counter, int endCounter) {
    this.counter = counter;
    this.endCounter = endCounter;
  }

  @Override
  public void run() {
    while (stopper) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        stopper = false;
        return;
      }

      counter++;
      System.out.println(Thread.currentThread().getName() + ": " + counter);
    }
  }

  public int getEndCounter() {
    return endCounter;
  }

  public int getCounter() {
    return counter;
  }


  @Override
  public int compareTo(CounterThread o) {
    return getDifferences().compareTo(o.getDifferences());
  }


  private Integer getDifferences() {
    return endCounter - counter;

  }
}
