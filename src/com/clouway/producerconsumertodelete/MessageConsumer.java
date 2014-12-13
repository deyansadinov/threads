package com.clouway.producerconsumertodelete;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class MessageConsumer implements Runnable {
  private final Controller controller;

  public MessageConsumer(Controller controller) {
    this.controller = controller;
  }

  @Override
  public void run() {
    System.out.println(controller.take().get(0));
    System.out.println(controller.take().get(1));
  }
}
