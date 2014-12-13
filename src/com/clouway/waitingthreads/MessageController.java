package com.clouway.waitingthreads;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class MessageController {
  private int counter;
  private boolean empty = true;

  public synchronized Integer take() {
    while (empty) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
    empty = true;
    notifyAll();
    return counter;
  }

  public synchronized void put(int counter) {
    while (!empty) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    empty = false;

    this.counter = counter;
    notifyAll();
  }

}
