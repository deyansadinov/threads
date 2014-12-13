package com.clouway.producerconsumer;


/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Demo {
  public static void main(String[] args) {
    Drop drop = new Drop();

    Thread threadOne = new Thread(new Producer(drop, 5));
    Thread threadTwo = new Thread(new Consumer(drop));

    threadOne.start();
    threadTwo.start();
  }
}
