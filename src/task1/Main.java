package task1;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Main {

  public static void main(String[] args) {
    Thread getTime = new GetData();

    getTime.start();
  }


}
