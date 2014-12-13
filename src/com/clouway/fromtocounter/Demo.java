package com.clouway.fromtocounter;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Demo {
  public static void main(String[] args) {
    ThreadFlag threadFlag = new ThreadFlag();

    Thread thread = new Thread(new Producer(6, threadFlag));
    Thread thread2 = new Thread(new Producer(5, threadFlag));
    Thread thread3 = new Thread(new Producer(1, threadFlag));

    thread.start();
    thread2.start();
    thread3.start();
  }
}