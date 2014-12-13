package com.clouway.producerconsumertodelete;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Controller {
  private List<String> messages = new ArrayList<String>();
  private boolean empty = true;

  public synchronized List<String> take() {
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

  public synchronized void put(String message) {
    while (!empty) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    empty = false;
    messages.add(message);
    notifyAll();

  }


}
