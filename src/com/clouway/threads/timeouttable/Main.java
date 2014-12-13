package com.clouway.threads.timeouttable;

import com.google.common.collect.Lists;
import org.jmock.lib.concurrent.internal.Timeout;

import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by clouway on 14-11-17.
 */
public class Main {

  public static void main(String[] args) {
//    TimeoutTable tTable = new TimeoutTable(4);
//    testWithTwoNumbers(tTable);

    TimeoutTable<Integer, Integer> tTable2 = new TimeoutTable<Integer, Integer>(4);
    anotherTestWithTwoNumbers(tTable2);


  }

  private static void anotherTestWithTwoNumbers(TimeoutTable<Integer, Integer> tTable2) {
    insertNumber(tTable2,1,1);
    insertNumber(tTable2,1,1);
    insertNumber(tTable2,2,2);
    insertNumber(tTable2,1,1);
    insertNumber(tTable2,1,1);
    insertNumber(tTable2,1,1);
    insertNumber(tTable2,1,1);
    insertNumber(tTable2,2,2);
  }

  private static void testWithTwoNumbers(TimeoutTable tTable) {
    insertNumber(tTable, 1,1);
    insertNumber(tTable, 1,1);
    insertNumber(tTable, 1, 1);
    insertNumber(tTable, 1, 1);
    sleepAWhile(4);
    insertNumber(tTable, 2,2);
    insertNumber(tTable, 2,2);
    insertNumber(tTable, 2,2);
    insertNumber(tTable, 2, 2);
    sleepAWhile(4);
  }


  private static <K, V> void insertNumber(TimeoutTable<K, V> tTable, K key, V value) {
    System.out.println("-----------------------");
    System.out.println("Inserting " + key);
    tTable.put(key, value);
    sleepAWhile(1);
  }


  public static void sleepAWhile(int time) {
    System.out.println("Sleeping for " + time);
    try {
      sleep(time * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
