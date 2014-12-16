package task2;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class CounterThread extends Thread {

  private final int limit;
  int count = 0;


  private boolean running = true;

  private CounterThread threadTwo;

  public CounterThread(int limit) {
    this.limit = limit;
  }

  public void setThread(CounterThread threadTwo) {

    this.threadTwo = threadTwo;
  }

  public void setRunning(boolean running) {
    this.running = running;
  }


  public void run() {
    while (running) {
      if (count != limit) {
        System.out.println(Thread.currentThread().getName() + " " + count);
        count++;
      }
      if (limit == count) {
        running = false;
        threadTwo.setRunning(false);
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
    }
  }
}
