package task3;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class ProduceConsumeDemo {

  public static void main(String[] args) {

    ProductionLine productionLine = new ProductionLine();

    new Factory(productionLine).start();
    new Consumer(productionLine).start();

  }
}
