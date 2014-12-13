package com.clouway.producerconsumer;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Drop {
  private String message;
  private boolean empty = true;

  public synchronized String take() {
    while (empty) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    empty = true;
    notifyAll();
    return message;
  }

  public synchronized void put(String message) {
    while (!empty) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    empty = false;
    if (!message.isEmpty()) {
      System.out.println(Thread.currentThread().getName() + ": " + message);
    }

    this.message = message;
    notifyAll();
  }
}
