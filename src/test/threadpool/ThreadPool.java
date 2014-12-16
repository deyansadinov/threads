package test.threadpool;


/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class ThreadPool implements  Runnable {

  private int id;

  public ThreadPool(int id) {
    this.id = id;
  }

  public void run() {
    System.out.println("Starting: " + id);

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
    }

    System.out.println("Completed: " + id);
  }
}



