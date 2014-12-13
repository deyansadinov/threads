package com.clouway.exceptionsthread;

import com.google.common.collect.Lists;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Producer implements Runnable {
  private Connector connector;

  public Producer(Connector connector) {
    this.connector = connector;
  }

  @Override
  public void run() {
    connector.put(Lists.<Object>newArrayList());
  }
}
