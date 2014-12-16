package task1;

import java.util.Scanner;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */

public class Counter extends Thread {

  private final int limit;
  int count = 0;

  public Counter(int limit) {

    this.limit = limit;
  }

  public void run() {

    while (count != limit) {
      count++;
      System.out.println("Current time in seconds " + count);
//      System.out.println(Thread.currentThread().getName() + count);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("CounterThread has reach " + count);
        break;
      }
    }
    System.out.println("CounterThread has finish");
  }



  public void setBreakPoint() {

    System.out.println("Starting CounterThread");
    Scanner scanner = new Scanner(System.in);
    String breakPoint = scanner.nextLine();

//    if (!breakPoint.equals("")) {
//      return;
//    }
      scanner.close();
  }
}
