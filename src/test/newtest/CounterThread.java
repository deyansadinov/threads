package test.newtest;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class CounterThread extends Thread {
  private final int limit;

  private boolean active = true;
  private int count = 0;
  private CounterThread secondThread;
  private CounterThread threeThread;


  public CounterThread(int limit) {
    this.limit = limit;

  }

  public void thread(CounterThread secondThread,CounterThread threeThread){
    this.secondThread = secondThread;
    this.threeThread = threeThread;
  }

  public void set(boolean active){

    this.active = active;
  }


  public void run(){

    while(active){
      if (count != limit){
        System.out.println(Thread.currentThread().getName()+ " " + count);
        count++;
      }
      if (count == limit){
        active = false;
        secondThread.set(false);
        threeThread.set(false);
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
