package test.newtest;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Main {
  public static void main(String[] args) {

    CounterThread counterThread1 = new CounterThread(5);
    CounterThread counterThread2 = new CounterThread(4);
    CounterThread counterThread3 = new CounterThread(7);

    counterThread1.thread(counterThread2,counterThread3);
    counterThread2.thread(counterThread1,counterThread3);
    counterThread3.thread(counterThread1,counterThread2);

    Thread t1 = new Thread(counterThread1,"Thread One");
    Thread t2 = new Thread(counterThread2,"Thread Two");
    Thread t3 = new Thread(counterThread3,"Thread Three");

    t1.start();
    t2.start();
    t3.start();
  }
}
