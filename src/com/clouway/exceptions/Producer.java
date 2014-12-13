package com.clouway.exceptions;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Producer implements Runnable {
  private Connector connector;
  private List<Object> messages;

  public Producer(Connector connector, List<Object> messages) {
    this.connector = connector;
    this.messages = messages;
  }

  @Override
  public void run() {
    connector.put(messages);
  }


}