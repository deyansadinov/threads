package com.clouway.exceptions;

import com.google.common.collect.Lists;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */

public class Demo {
  public static void main(String[] args) throws InterruptedException {
    Connector connector = new Connector(3);

    Thread producerThread = new Thread(new Producer(connector, Lists.<Object>newArrayList()));
    Thread consumerThread = new Thread(new Consumer(connector));

    producerThread.start();
    consumerThread.start();
  }
}