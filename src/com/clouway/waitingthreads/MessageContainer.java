package com.clouway.waitingthreads;

import java.util.Collections;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class MessageContainer implements Runnable, Comparable<MessageContainer> {
  private static final int start = 0;
  private final int end;

  public MessageContainer(int end) {
    this.end = end;
  }

  @Override
  public void run() {
    ss1();
  }

  private void ss1() {
    for (int i = 0; i < end; i++) {
      System.out.println(Thread.currentThread().getName() + ": " + i);

      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      notify();
    }
  }

  @Override
  public int compareTo(MessageContainer o) {
    return subtract().compareTo(o.subtract());
  }

  public Integer subtract() {
    return end - start;
  }

  public int getEnd() {
    return end;
  }
}
