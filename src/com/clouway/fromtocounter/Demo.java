package com.clouway.fromtocounter;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Demo {
  public static void main(String[] args) {
    ThreadFlag threadFlag = new ThreadFlag();

    Thread thread = new Thread(new ThreadCounter(6, threadFlag));
    Thread thread2 = new Thread(new ThreadCounter(5, threadFlag));

    thread.start();
    thread2.start();
  }
}