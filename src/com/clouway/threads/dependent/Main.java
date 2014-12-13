package com.clouway.threads.dependent;

import com.clouway.threads.listofobjects.ObjectList;

/**
 * Created by clouway on 14-10-30.
 */
public class Main {

  public static void main(String[] args) {
    ThreadCounter counterOne = new ThreadCounter(5);
    ThreadCounter counterTwo = new ThreadCounter(10);

    counterOne.waitFor(counterTwo);
    counterTwo.waitFor(counterOne);

    Thread threadOne = new Thread(counterOne);
    Thread threadTwo = new Thread(counterTwo);

    threadOne.start();
    threadTwo.start();
  }

}
