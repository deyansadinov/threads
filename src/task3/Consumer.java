package task3;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Consumer implements Runnable {

  private ProductionLine productionLine;

  public Consumer(ProductionLine productionLine) {
    this.productionLine = productionLine;
  }

  public void run(){
    int value ;
    for (int i = 0;i < 5; i++){
      value = productionLine.get();
      System.out.println("Thread " + Thread.currentThread().getName() + " got " + value );
    }
  }

  public void start(){
    new Thread(this).start();
  }
}
