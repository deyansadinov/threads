package test.test3task5;

import java.util.Map;
import java.util.Hashtable;
/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class ThreadedValue<T> extends Thread  {

  private T value;
  private Map timeOutTable;
  private Integer timer;
  private T key;
  private boolean active = true;
  private int suspend = 0;

  public ThreadedValue(T value, Map timeOutTable, Integer timer, T key) {
    this.value = value;
    this.timeOutTable = timeOutTable;
    this.timer = timer;
    this.key = key;


  }

  public void setValue(T value) {
    this.value = value;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public T getValue() {
    return value;
  }

  public void reset() {
    suspend = 0;
  }

  public void terminate() {
    suspend = timer;
    active = false;
  }

  public void run() {

    while (active) {
      System.out.printf(" %s %s time left %s \n", key, value, (timer - suspend));
      suspend++;

      if (suspend == timer) {
        active = false;
      }
      try {
        sleep(1000);
      } catch (InterruptedException e) {
      }

    }
  }


}
