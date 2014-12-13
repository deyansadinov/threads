package com.clouway.exceptions;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Consumer implements Runnable {
  private Connector connector;

  public Consumer(Connector connector) {
    this.connector = connector;
  }

  @Override
  public void run() {
    Object messages = connector.take();
    System.out.println(messages);
  }
}