package com.clouway.waitingthreads;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class MessageConsumer implements Runnable {
  private MessageController messageController = new MessageController();

  public MessageConsumer(MessageController messageController) {
    this.messageController = messageController;
  }

  @Override
  public void run() {
    Integer i = messageController.take();
//    System.out.println(i);
    while (!i.equals(null)) {
      i = messageController.take();
      System.out.println(i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

}
