package task5;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class TimeoutHashTableDemo {
  public static void main(String[] args) {
    TimeoutHashtable<String,String> table = new TimeoutHashtable<String, String>(10);

    String dido = "dido";
    String petar = "petar";
    String vasko = "vasko";
    String gosho = "gosho";

    table.put("dido",dido);
    table.put("petar",petar);
    table.put("vasko",vasko);
    table.put("gosho",gosho);


    table.get("dido");
    System.out.println(table.get("dido"));
    table.get("gosho");

    System.out.println(table.get("gosho"));

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(table.get("vasko"));
    table.get("vasko");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(table.get("petar"));

  }
}
