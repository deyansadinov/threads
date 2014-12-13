package com.clouway.threadcounter3task;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Demo {
  public static void main(String[] args) {
    Threads threads = new Threads(4);

    Thread threadOne = new Thread(threads);
    Thread threadTwo = new Thread(threads);

    threadOne.start();
    threadTwo.start();
  }
}
