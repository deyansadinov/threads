package com.clouway.exceptionsthread;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Demo {
  public static void main(String[] args) throws InterruptedException {
    Connector connector = new Connector(2);
    Producer producer = new Producer(connector);
    Consumer consumer = new Consumer(connector);

    Thread producerThread = new Thread(producer);
    Thread consumerThread = new Thread(consumer);

    producerThread.start();
    consumerThread.start();
  }
}
