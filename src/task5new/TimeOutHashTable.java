package task5new;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class TimeOutHashTable<K, V> {

  private final int limit;

  private Map<K, ThreadTimeOutTable<V>> containerTable = new Hashtable<K, ThreadTimeOutTable<V>>();

  public TimeOutHashTable(int limit) {
    this.limit = limit;
  }

  public void put(K key, V value){
    ThreadTimeOutTable<V> threadTable = new ThreadTimeOutTable<V>(value,containerTable,limit, (V) key);
    Thread thread = new Thread(threadTable);

    if(containerTable.get(key) != null){
      containerTable.get(key).set(false);
    }

    containerTable.put(key,threadTable);
    thread.start();
  }

  public V get(K key){
    if (!containerTable.containsKey(key)){
      return null;
    }
    containerTable.get(key).interrupt();
    return containerTable.get(key).getValue();
  }

  public V remove(K key){
    if (!containerTable.containsKey(key)){
      return null;
    }
    return containerTable.remove(key).getValue();
  }
}
