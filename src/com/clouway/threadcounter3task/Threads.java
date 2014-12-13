package com.clouway.threadcounter3task;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Threads implements Runnable {
  private final int counter;

  public Threads(int counter) {

    this.counter = counter;
  }

  @Override
  public void run() {
    get();

  }

  private synchronized void get() {
    for (int i = 0; i < counter; i++) {
      print(Thread.currentThread().getName() + " : " + i);
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private synchronized void print(String print) {
    System.out.println(print);

    notifyAll();
  }
}


