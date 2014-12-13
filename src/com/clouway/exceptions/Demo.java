package com.clouway.exceptions;

/**
 * @author Tihomir Kehayov <kehayov89@gmail.com>
 */
public class Demo {
  public static void main(String[] args) {
    ExceptionList e = new ExceptionList(2);
    e.add("qqqq");
    e.add("asdasd");
    e.add("asdasd1");
    e.remove();

    e.printAllElements();
  }
}
