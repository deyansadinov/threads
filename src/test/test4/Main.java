package test.test4;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Main {
  public static void main(String[] args)  {
    TimeOutTable<String,Integer> timeOutTable = new TimeOutTable<String, Integer>(5);

    timeOutTable.put("BMW",200);
    timeOutTable.put("Opel",90);

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    timeOutTable.put("BMW",100);
    timeOutTable.put("Opel",50);
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("--------------");
    System.out.println("Remove key with value " +timeOutTable.remove("Opel"));
    System.out.println("Get key with value " +timeOutTable.get("BMW"));
    System.out.println("Get key with value " +timeOutTable.get("Opel"));
  }
}
