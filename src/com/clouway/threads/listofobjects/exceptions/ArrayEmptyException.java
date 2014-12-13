package com.clouway.threads.listofobjects.exceptions;

/**
 * Created by clouway on 14-9-15.
 */
public class ArrayEmptyException extends RuntimeException {

  public ArrayEmptyException() {
    super("ObjectList is empty.");
  }
}
