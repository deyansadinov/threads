package test;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class TestMain {
  public static void main(String[] args) {

    Test count1 = new Test(2);
    Test count2 = new Test(3);

    count1.setTarget(count2);
    count2.setTarget(count1);

    Thread t1 = new Thread(count1,"Thread One");
    Thread t2 = new Thread(count2,"Thread Two");

    t1.start();
    t2.start();
  }
}
