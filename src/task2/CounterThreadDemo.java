package task2;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class CounterThreadDemo {
  public static void main(String[] args) {

    CounterThread count1 = new CounterThread(6);
    CounterThread count2 = new CounterThread(5);

    count1.setThread(count2);
    count2.setThread(count1);



    Thread t1 = new Thread(count1,"Thread One");
    Thread t2 = new Thread(count2,"Thread Two");

    t1.start();
    t2.start();

  }
}
