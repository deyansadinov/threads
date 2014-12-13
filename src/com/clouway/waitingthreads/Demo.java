package com.clouway.waitingthreads;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Demo {
  public static void main(String[] args) {
    MessageController messageController = new MessageController();
    Thread thread1 = new Thread(new MessageProducer(0, 5, messageController));
    Thread thread2 = new Thread(new MessageProducer(0, 5, messageController));

    Thread thread3 = new Thread(new MessageConsumer(messageController));

    thread1.start();
    thread2.start();
    thread3.start();
  }

}
