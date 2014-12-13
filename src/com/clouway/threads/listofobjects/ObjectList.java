package com.clouway.threads.listofobjects;

import com.clouway.threads.listofobjects.exceptions.ArrayEmptyException;
import com.clouway.threads.listofobjects.exceptions.ArrayFullException;

/**
 * Created by clouway on 14-9-15.
 */
public class ObjectList {

  private int size;
  private int numElements = 0;
  private Object[] objectList;


  public ObjectList(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("ObjectList can't have zero or negative number of elements");
    }
    this.size = size;
    this.objectList = new Object[size];
  }

  public synchronized void addItem(Object item) throws ArrayFullException {
    while (numElements > 0) {
      waitUntilNotify();
    }
    if (numElements == size) {
      throw new ArrayFullException(objectList.length);
    }
    objectList[numElements++] = item;
    notifyAll();
  }

  public synchronized Object remove() throws ArrayEmptyException {
    while (numElements == 0){
      waitUntilNotify();
    }
    if (numElements == 0) {
      throw new ArrayEmptyException();
    }
    Object removed = objectList[--numElements];
    objectList[numElements] = null;
    notifyAll();
    return removed;
  }

  public int size(){
    return size;
  }

  private void waitUntilNotify() {
    try {
      wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
