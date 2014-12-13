package com.clouway.producerconsumer;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Consumer implements Runnable {
  private Drop drop;

  public Consumer(Drop drop) {
    this.drop = drop;
  }

  @Override
  public void run() {
    for (String message = drop.take();
         !message.isEmpty();
         message = drop.take()) {
      System.out.println(Thread.currentThread().getName() + ": " + message);
    }
  }
}
