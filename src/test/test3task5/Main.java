package test.test3task5;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Main {
  public static void main(String[] args) {
    TimeOutTable<String, String> timeOutTable = new TimeOutTable<String, String>(3);


    try {
      timeOutTable.put("Dido", "BMW");
      timeOutTable.put("petar", "opel");
      Thread.sleep(2000);
    } catch (InterruptedException e) {
    }

    try {

      timeOutTable.put("Dido","VW");

      Thread.sleep(2000);
    } catch (InterruptedException e) {
    }
    System.out.println("--------------");

    System.out.println(timeOutTable.get("Dido"));


    System.out.println();
  }

}
