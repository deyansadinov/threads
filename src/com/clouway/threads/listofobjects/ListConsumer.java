package com.clouway.threads.listofobjects;

import java.util.Random;

/**
 * Created by clouway on 14-10-31.
 */
public class ListConsumer implements Runnable {

  private ObjectList oList;
  private int sleepTime;

  public ListConsumer(ObjectList oList, int sleepTime) {
    this.oList = oList;
    this.sleepTime = sleepTime;
  }

  @Override
  public void run() {
    for (int i = 0 ; i < oList.size(); i++) {
      sleepAWhile();
      System.out.format("%s: %s%n", Thread.currentThread().getName(), oList.remove().toString());
    }
  }

  private void sleepAWhile() {
    Random random = new Random();
    try {
      Thread.sleep(random.nextInt(sleepTime));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
