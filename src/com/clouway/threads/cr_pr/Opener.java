package com.clouway.threads.cr_pr;


/**
 * Created by clouway on 14-12-13.
 */
public class Opener<V> extends Thread implements Consumer {

  private final Packagable<V> box;
  private boolean consumed;

  public Opener(Packagable<V> box) {
    this.box = box;
    box.registerConsumer(this);
  }

  @Override
  public void run() {

    while (!box.isDiscarded()) {

      while (consumed) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      consumed = true;
      V prize = box.unpack();
      System.out.println(prize.toString());
      sleepAWhile(1);
    }
  }


  @Override
  public void canConsume() {
    consumed = false;
  }

  private void sleepAWhile(int seconds) {
    try {
      sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


}
