package test.test2;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Test2 extends Thread {
  private final int limit;
  private int count = 0;
  private Test2 thread;

  public Test2(int limit) {

    this.limit = limit;
  }

  @Override
  public void run() {
    while (count != limit) {
      count++;
      if (count == limit) {
        if (isInterrupted()) {
          System.out.println(getName() + " interrupted.");
          break;
        }
      }
      System.out.println(getName() + " count " + count);
    }
    thread.interrupt();
  }

  public void setThread(Test2 thread) {
    this.thread = thread;
  }
}
