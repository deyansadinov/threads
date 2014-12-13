package com.clouway.threads.thread4;

/**
 * Created by clouway on 14-9-23.
 */
public class ObjectContainer {
  private Object[] array;
  private int valueSet;

  public ObjectContainer(int length) {
    this.array = new Object[length];
  }


  public synchronized Object[] add(){
     if (valueSet >= array.length){
       try {
         wait();
       } catch (InterruptedException e) {
         e.printStackTrace();
       }
     }
    valueSet++;
    notifyAll();
    System.out.println("add: " + valueSet);
    return array;
  }

  public synchronized Object[] remove(){
    if (valueSet <= 0){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    valueSet--;
    notifyAll();
    System.out.println("remove: " + valueSet);
    return array;
  }
}
