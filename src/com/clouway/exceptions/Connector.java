package com.clouway.exceptions;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.Thread.sleep;

public class Connector {
  private final int messageLength;
  private List<Object> messages = new Vector<Object>();
  private boolean empty = true;

  public Connector(int messageLength) {
    this.messageLength = messageLength;
  }

  public synchronized List<Object> take() {
    while (empty) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    empty = true;
    notifyAll();
    return messages;
  }

  public synchronized void put(List<Object> messages) {
    while (!empty) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if (messages.isEmpty()) {
      addMessage(messages);
    }
    if (messageLength < messages.size()) {
      messages = messages.subList(0, messageLength);
      notifyAll();
    }
    this.messages = messages;
    empty = false;
    notifyAll();
  }

  private void addMessage(List<Object> messages) {
    Scanner reader = new Scanner(System.in);
    messages.add(reader.nextLine());
  }
}