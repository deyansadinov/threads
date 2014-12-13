package com.clouway.threads.cr_pr;

/**
 * Created by clouway on 14-12-13.
 */
public class Packager<V> extends Thread {
  private final Packagable<V> box;
  private final V[] packMe;

  public Packager(Packagable<V> box, V[] packMe) {
    this.box = box;
    this.packMe = packMe;
    box.registerProducer(this);
  }

  @Override
  public void run() {
    for (V each : packMe) {
      box.pack(each);
      System.out.println("Packed: " + each.toString());
      sleepAWhile(1);
    }
    box.discard();
  }

  private void sleepAWhile(int seconds) {
    try {
      sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
