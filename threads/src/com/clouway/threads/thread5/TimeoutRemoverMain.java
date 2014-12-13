package com.clouway.threads.thread5;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TimeoutRemoverMain {
  public static void main(String[] args) {
    TimeoutHashTable timeoutHashTable = new TimeoutHashTable(2);
    Person person = new Person();

    timeoutHashTable.put("Ivan", person);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(timeoutHashTable.get("Ivan"));
    System.out.println("==========");

    try {
      Thread.sleep(1900);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(timeoutHashTable.get("Ivan"));

  }
}
