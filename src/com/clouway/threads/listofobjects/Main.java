package com.clouway.threads.listofobjects;

/**
 * Created by clouway on 14-10-31.
 */
public class Main {


  public static void main(String[] args) {
    ObjectList oList = new ObjectList(32);

    ListProducer producer = new ListProducer(oList, 1000);
    ListConsumer consumer = new ListConsumer(oList, 1000);

    new Thread(producer).start();
    new Thread(consumer).start();
  }

}
