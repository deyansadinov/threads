package task3;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Factory implements Runnable {

  private ProductionLine productionLine;

  public Factory(ProductionLine productionLine) {
    this.productionLine = productionLine;
  }

  public void run(){
    for (int i = 0; i < 5; i++){
      productionLine.put(i);
      System.out.println("Thread " + Thread.currentThread().getName() + " put " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void start(){
    new Thread(this).start();
  }


}
