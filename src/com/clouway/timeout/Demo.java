package com.clouway.timeout;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Demo {
  public static void main(String[] args) throws InterruptedException {
    TimeoutInterval timeoutInterval = new TimeoutInterval() {{
      put("Ivan", 2);
      put("George", 3);
      put("PeterPan", 1);
    }};

    TimeoutHashTable<String, Long> timeoutHashTable = new TimeoutHashTable<String, Long>(timeoutInterval);

    timeoutHashTable.put("Ivan", new Date().getTime());
    Thread.sleep(1900);
    timeoutHashTable.put("George", new Date().getTime());

    try {
      Long millis = timeoutHashTable.get("Ivan");
      System.out.println(millis);
    } catch (TimeOutOverflowException e) {
      System.out.println("Limit timeout overflow. Deleted!");
    }

    timeoutHashTable.put("George", new Date().getTime());
    timeoutHashTable.put("PeterPan", new Date().getTime());
  }
}
