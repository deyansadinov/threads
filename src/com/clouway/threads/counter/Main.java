package com.clouway.threads.counter;

import java.util.Scanner;

/**
 * Created by clouway on 14-10-30.
 */
public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Thread timer = new Thread(new InputTimeCounter(100));

    timer.start();

    while (timer.isAlive()){
      if(scanner.next() != null){
        timer.interrupt();
      }
    }


  }

}
