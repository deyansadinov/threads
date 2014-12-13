package com.clouway.fromtocounter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Producer implements Runnable {
  private Integer endCounter;
  private ThreadFlag threadFlag;
  private Integer counter = 0;

  public Producer(int endCounter, ThreadFlag threadFlag) {
    this.endCounter = endCounter;
    this.threadFlag = threadFlag;
  }

  @Override
  public void run() {
    while (threadFlag.getFlag()) {
      counter++;
      if (counter != endCounter) {

        System.out.println(Thread.currentThread().getName() + ": " + counter);
      } else {
        threadFlag.setFlag(false);
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
