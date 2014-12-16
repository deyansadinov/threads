package task5;

import java.util.Map;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class TimeoutThread<K, T> extends Thread {
  private final Map<K, TimeoutThread<K, T>> container;
  private final int limitTime;
  private final T data;
  private final K key;

  public TimeoutThread(Map<K, TimeoutThread<K, T>> container, int limitTime, T data, K key) {

    this.container = container;
    this.limitTime = limitTime;
    this.data = data;
    this.key = key;
  }

  public void run(){
    while (true){
      try {
        sleep(limitTime);
        break;
      } catch (InterruptedException e) {
        System.out.printf("Renew  timer for: %s\n" ,key);
      }
    }
    if (container.containsValue(this)){
      container.remove(key);
    }
  }

  public T getData(){
    return data;
  }
}
