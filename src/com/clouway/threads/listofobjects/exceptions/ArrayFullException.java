package com.clouway.threads.listofobjects.exceptions;

/**
 * Created by clouway on 14-9-15.
 */
public class ArrayFullException extends RuntimeException {
  public ArrayFullException(int capacity) {
    super(String.format("Capacity is '%s'.",capacity));
  }
}
