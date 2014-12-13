package com.clouway.timecounter;

import java.util.Scanner;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Demo {
  public static void main(String[] args) {
    MessageContainer container = new MessageContainer();
    Thread thread = new Thread(container);

    thread.start();
    while (thread.isAlive()) {

      Scanner reader = new Scanner(System.in);
      String content = reader.next();

      if (!content.isEmpty()) {
        thread.interrupt();
      }
      System.out.println(container.getSecondCounter());
    }
  }
}