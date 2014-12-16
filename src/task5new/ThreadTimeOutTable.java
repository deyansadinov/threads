package task5new;

import java.util.Map;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class ThreadTimeOutTable<V> extends Thread {
  private final V value;
  private final Map containerTable;
  private int timer;
  private final V key;
  private boolean run = true;

  public ThreadTimeOutTable(V value, Map containerTable, int timer, V key) {
    this.value = value;
    this.containerTable = containerTable;
    this.timer = timer;
    this.key = key;
  }

  public void set(boolean run) {
    this.run = run;
  }

  public V getValue() {
    return value;
  }



  public void run(){
    while (run){
      System.out.printf(" %s %s time left %s\n",key,value,timer);

      timer--;

      if (timer == 0){
        containerTable.remove(key);
        run = false;
      }
      try {
        sleep(1000);
      } catch (InterruptedException e) {

      }
    }
  }
}
