package task4;


import java.util.List;
import java.util.Random;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class ThreadRemover extends Thread {

  private final List<Integer> list;

  public ThreadRemover(List<Integer> list) {
    this.list = list;
  }

  public void remove() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (list) {
          while (list.size() == 0) {
            try {
              System.out.println("Waiting...");
              list.wait();

            } catch (InterruptedException e) {

            }
          }
          list.notify();
          System.out.println("Removed element: " + list.remove(0));
        }
      }
    }).start();
  }
}
