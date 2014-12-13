package com.clouway.waitingthreads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class MessageProducer implements Runnable {
  private final int startIndex;
  private final int endIndex;
  private MessageController messageController = new MessageController();

  public MessageProducer(int startIndex, int endIndex, MessageController messageController) {
    this.startIndex = startIndex;
    this.endIndex = endIndex;
    this.messageController = messageController;
  }

  @Override
  public void run() {
//    messageController
    for (int i = startIndex; i < endIndex; i++) {
      messageController.put(i);
//      System.out.println(Thread.currentThread().getName() + ": " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
