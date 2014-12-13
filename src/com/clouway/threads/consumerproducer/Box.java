package com.clouway.threads.consumerproducer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clouway on 14-12-13.
 */
public class Box<V> implements Packagable<V> {

  private List<Opener<V>> consumers;
  private Packager<V> producer;

  private V prize;
  private boolean empty;
  private boolean discarded;
  private int openings;

  public Box() {
    empty = true;
  }

  @Override
  public void registerConsumer(Opener<V> opener) {
    if (consumers == null) {
      consumers = new ArrayList<Opener<V>>();
    }
    consumers.add(opener);
  }

  @Override
  public void registerProducer(Packager<V> packager) {
    if (producer != null) {
      return;
    }
    producer = packager;
  }

  @Override
  public synchronized V unpack() {

    while (empty) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    openings++;

    if (openings == consumers.size()) {
      empty = true;
      lineUpConsumers();
      notifyAll();
    }
    return prize;
  }

  @Override
  public synchronized void pack(V value) {

    while (!empty) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    prize = value;
    empty = false;
    openings = 0;
    notifyAll();
  }

  @Override
  public synchronized boolean isDiscarded() {
    return discarded;
  }

  @Override
  public synchronized void discard() {
    discarded = true;
  }

  private void lineUpConsumers() {
    for (Consumer each : consumers) {
      each.canConsume();
    }

  }

}
