package task4;


import java.util.List;
import java.util.Random;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class ThreadAdder {
  private final List<Integer> list;
  private final int size;

  public ThreadAdder(List<Integer> list, int maxSize) {
    this.list = list;
    this.size = maxSize;
  }

  public void add(final int value) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (list) {
          while (list.size() == size) {
            try {
              System.out.println("List is full");
              list.wait();
            } catch (InterruptedException ignored) {

            }
          }
          list.notifyAll();
          System.out.printf("Element %d has been added \n", value);
          list.add(value);
        }
      }
    }).start();

//        System.out.println("List size is " + list.size());

  }
}
