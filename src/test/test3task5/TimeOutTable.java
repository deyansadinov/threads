package test.test3task5;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class TimeOutTable<K, V> {

  private Map<K, ThreadedValue<V>> timeOutTable = new Hashtable<K, ThreadedValue<V>>();
  private Integer timer;
  private ThreadedValue<V> threadAdd;


  public TimeOutTable(Integer timer) {
    this.timer = timer;
  }

  public void put(K key, V value) {

    if (timeOutTable.containsKey(key)) {
      threadAdd = timeOutTable.get(key);
      threadAdd.reset();
      threadAdd.setValue(value);
    } else {
      threadAdd = new ThreadedValue<V>(value, timeOutTable, timer, (V) key);
      threadAdd.start();
    }
    timeOutTable.put(key, threadAdd);
  }

  public V get(K key) {
    if (timeOutTable.get(key) != null) {
      timeOutTable.get(key).reset();
      return timeOutTable.get(key).getValue();
    }
    return null;
  }

  public V remove(K key) {
    if (timeOutTable.get(key) != null) {
      timeOutTable.get(key).terminate();
      timeOutTable.remove(key);
    }
    return null;
  }
}
