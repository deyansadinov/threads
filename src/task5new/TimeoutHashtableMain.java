package task5new;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class TimeoutHashtableMain {
  public static void main(String[] args) {
    TimeOutHashTable<String,String> table = new TimeOutHashTable<String, String>(5);

    table.put("dido","BMW");


    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("---------------------------");
    table.put("dido","Opel");

    System.out.println(table.get("dido"));
//    System.out.println();
//    try {
//      Thread.sleep(2000);
//    } catch (InterruptedException e) {
//
//    }
  }
}
