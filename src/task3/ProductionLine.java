package task3;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class ProductionLine {


  private  int count;
  private boolean active = false;

  public synchronized int get(){
    while (!active){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    active = false;
    notifyAll();

    return count;
  }

  public synchronized int put(int value){
    while (active){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    count = value;
    active = true;
    notifyAll();

    return count;
  }
}
