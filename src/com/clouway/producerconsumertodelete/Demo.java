package com.clouway.producerconsumertodelete;

import com.clouway.producerconsumertodelete.Consumer;
import com.clouway.producerconsumertodelete.Drop;
import com.clouway.producerconsumertodelete.Producer;

//DEMO
public class Demo {
  public static void main(String[] args) {
    Drop drop = new Drop();
    (new Thread(new Producer(drop))).start();
    (new Thread(new Producer(drop))).start();
//    (new Thread(new Producer(drop))).start();
    (new Thread(new Consumer(drop))).start();
    (new Thread(new Consumer(drop))).start();
  }
}
