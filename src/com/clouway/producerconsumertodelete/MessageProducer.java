package com.clouway.producerconsumertodelete;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class MessageProducer implements Runnable {
  private boolean stopper = true;
  private int counter;
//  private final Controller controller;

  public MessageProducer(int counter) {
    this.counter = counter;


  }

  @Override
  public void run() {
    ss();
  }

  public synchronized void ss() {
    System.out.println("AasdasdasdDS");
    while (true) {
      if (counter == 10) {
        break;
      }
//      try {
//        Thread.sleep(1000);
//        wait();
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//        stopper = false;
//        return;
//      }
      System.out.println(Thread.currentThread().getName() + ": " + counter);
      counter++;
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
//    stopper = false;
    System.out.println("aaa");
    notifyAll();
  }
}
