package com.clouway.threads.thread3;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ProducerConsumerMain {
  public static void main(String[] args) {

    SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

    Thread producer = new Thread(new Producer(synchronizedCounter, 5));
    Thread consumer = new Thread(new Consumer(synchronizedCounter, 5));

    producer.start();
    consumer.start();
  }
}
