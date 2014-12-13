package com.clouway.fromtocounter;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class ThreadFlag {
  private boolean flag = true;

  public synchronized boolean getFlag() {
    return flag;
  }

  public synchronized void setFlag(boolean flag) {
    this.flag = flag;
  }
}
