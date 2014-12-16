package test.test2;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Test2Main {
  public static void main(String[] args) {

    Test2 count1 = new Test2(2);
    Test2 count2 = new Test2(4);

    count1.setThread(count2);
    count2.setThread(count1);

    Thread t1 = new Thread(count1,"Thread One");
    Thread t2 = new Thread(count2,"Thread Two");

    t1.start();
    t2.start();

//    Test2 counterTo100 = new Test2(100);
//    counterTo100.setPriority(1);
//    Test2 counterTo200 = new Test2(200);
//    counterTo100.setThread(counterTo200);
//    counterTo200.setThread(counterTo100);
//    counterTo200.setPriority(10);
//    counterTo100.start();
//    counterTo200.start();
  }
}
