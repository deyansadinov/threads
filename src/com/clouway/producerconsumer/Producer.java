package com.clouway.producerconsumer;

import static java.lang.Thread.sleep;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Producer implements Runnable {
  private Drop drop;
  private int endCounter;
  private Integer counter = 0;

  public Producer(Drop drop, int endCounter) {
    this.drop = drop;
    this.endCounter = endCounter;
  }

  @Override
  public void run() {
    while (counter != endCounter) {
      counter++;
//      System.out.println(Thread.currentThread().getName() + ": " + counter);
      drop.put(counter.toString());
      try {
        sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    drop.put("");
  }
}
