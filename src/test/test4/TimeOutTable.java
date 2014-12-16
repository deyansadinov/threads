package test.test4;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class TimeOutTable<K,V> {

  private final int limit;
  private Map<K, ThreadTable<K,V>> container = new Hashtable<K, ThreadTable<K,V>>();

  public TimeOutTable(int limit) {

    this.limit = limit;
  }

  public void put(K key, V value) {

    ThreadTable<K,V> threadTable = new ThreadTable<K,V>(key, value, container, limit);
    Thread thread = new Thread(threadTable);

    if (container.get(key) != null) {
      container.get(key).set(false);
    }
    container.put(key, threadTable);
    thread.start();

  }

  public V get(K key) {
    if (!container.containsKey(key)) {
      return null;
    }
    container.get(key).restart();
    return container.get(key).getValue();
  }

  public V remove(K key)  {
    if (!container.containsKey(key)) {
      return null;
    }
    container.get(key).disable();
    return container.remove(key).getValue();
  }
}
