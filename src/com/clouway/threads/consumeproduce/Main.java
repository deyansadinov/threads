package com.clouway.threads.consumeproduce;

/**
 * Created by clouway on 14-10-31.
 */
public class Main {

  public static void main(String[] args) {
    int[] array = {1,2,3,4,5,6,7,8};

    ConcurrentValue cValue = new ConcurrentValue();

    startThread(new Producer(cValue,array),500,"producer: ");
    startThread(new FirstConsumer(cValue),1000,"first: ");
    startThread(new SecondConsumer(cValue),1000,"second: ");
  }

  private static void startThread(final Activity activity, final int sleepAbout, String name) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        activity.execute(new Sleeper(sleepAbout));
      }
    }, name).start();
  }

}
