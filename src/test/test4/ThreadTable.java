package test.test4;

import java.util.Map;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class ThreadTable<K,V> extends Thread {


  private final K key;
  private final V value;
  private final Map<K, ThreadTable<K, V>> container;
  private int limit;
  private boolean active = true;
  private int rest = 0;


  public ThreadTable(K key, V value, Map<K, ThreadTable<K, V>> container,int limit) {

    this.key = key;
    this.value = value;
    this.container = container;
    this.limit = limit;
  }

  public V getValue() {
    return value;
  }

  public void run(){
    while (active){
      System.out.printf(" %s is driving with %s km/h is going down after %s\n",key,value,(limit-rest));
      rest++;

      if (limit == rest){
        container.remove(key);
        active = false;

      }
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  public void set(boolean active) {
    this.active = active;
  }

  public void restart() {
     rest = 0;
  }

  public void disable() {
    rest = limit;
    active = false;
  }
}
