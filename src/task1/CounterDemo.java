package task1;



/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class CounterDemo {
  public static void main(String[] args) {

    Counter counter = new Counter(100);

    counter.start();

    counter.setBreakPoint();

    counter.interrupt();

  }
}
