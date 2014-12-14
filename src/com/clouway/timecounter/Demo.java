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
    Scanner reader = new Scanner(System.in);
    String content = reader.nextLine();
    while (!thread.isInterrupted()) {
      if (!content.isEmpty()) {
        thread.interrupt();
        container.changeFlag();
      }
    }
    System.out.println(container.getSecondCounter());
  }
}