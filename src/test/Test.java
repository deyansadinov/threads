package test;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Test extends Thread{

  private int timer;
  private boolean active = true;
  private Test secondCounter;

  public Test(int timer) {

    this.timer = timer;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void setTarget(Test secondCounter) {
    this.secondCounter = secondCounter;
  }


  public void setTimer(int timer) {
    this.timer = timer;
  }

  public void run() {
    while (active) {
      for (int i = 0; i <= timer; i++) {
        System.out.println(Thread.currentThread().getName() + " " + i);
        if (i==timer){
          secondCounter.setTimer(timer);
          secondCounter.setActive(false);
        }
        try {
          sleep(1000);
        } catch (InterruptedException e) {
        }

      }
      setActive(false);

    }

  }
}
