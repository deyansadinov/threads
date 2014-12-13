package com.clouway.exceptions;

import java.util.List;
import java.util.Vector;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class ExceptionList implements Runnable {
  private final List<Object> list = new Vector<Object>();
  private int length;

  public ExceptionList(int length) {
    this.length = length;
  }

  /**
   * adding object to element with null value.
   * If is already filled throw FilledArrayException
   *
   * @param obj object to add in array
   */
  public synchronized void add(Object obj) {
    if (list.size() == length) {
      throw new FilledArrayException();
    }

    list.add(obj);
  }

  /**
   * Remove last filled value
   * If is empty array throw EmptyArrayException
   */
  public synchronized void remove() {

    list.remove(list.size() - 1);
  }

  /**
   * Printing elements in ArrayList
   */
  public void printAllElements() {
    System.out.println(list);
  }

  @Override
  public void run() {

  }
}
