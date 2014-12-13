package com.clouway.threads.listofobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 * Created by clouway on 14-10-31.
 */
public class ListProducer implements Runnable {

  private ObjectList oList;
  private int sleepTime;
  private Object[] values =  {"Hello",7,"3.21S",45.3,"@#$@!","Finished",new ArrayList(),"DONE!"};

  public ListProducer(ObjectList oList, int sleepTime) {
    this.oList = oList;
    this.sleepTime = sleepTime;
  }

  @Override
  public void run() {
       for(int i = 0; i < values.length && i < oList.size(); i++){
         sleepAWhile();
         oList.addItem(values[i]);
       }
  }

  private void sleepAWhile(){
    Random random = new Random();
    try {
      Thread.sleep(random.nextInt(sleepTime));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


}
