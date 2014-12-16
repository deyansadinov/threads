package task5;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class TimeoutHashtable <K , V>{

  private final int limit;
  private Map<K , TimeoutThread<K, V>> container = new Hashtable<K, TimeoutThread<K, V>>();

  public TimeoutHashtable(int limit) {
    this.limit = limit;
  }

  /**
   * Put new thread in HashTable and start thread which adding value
   */
  public void put(K key, V value){
    TimeoutThread<K, V> thread = new TimeoutThread<K, V>(this.container,limit,value,key);
    container.put(key, thread);
    thread.start();
  }

/**
 * Get thread whit this key or return "null" if not contains this key.
 * Interrupt thread and restart timer.
 *
 * */
  public V get(String key){
    if (!container.containsKey(key)){
      return null;
    }
    container.get(key).interrupt();
    return container.get(key).getData();
  }

  public V remove(K key){
    if (!container.containsKey(key)){
      return null;
    }
    return container.remove(key).getData();
  }
 }
