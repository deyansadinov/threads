package com.clouway.producerconsumertodelete;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */

import java.util.Random;

public class Consumer implements Runnable {
  private Drop drop;

  public Consumer(Drop drop) {
    this.drop = drop;
  }

  public void run() {
//    Random random = new Random();
    for (String message = drop.take();
         !message.equals("DONE");
         message = drop.take()) {
      System.out.format("MESSAGE RECEIVED: %s%n", message);
//      try {
//        Thread.sleep(random.nextInt(10000));
//      } catch (InterruptedException e) {
//      }
    }
  }
}