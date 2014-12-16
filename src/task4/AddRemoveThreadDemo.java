package task4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class AddRemoveThreadDemo {
  public static void main(String[] args) {

    List<Integer> list = new ArrayList<Integer>();
    int size = 3;

    ThreadAdder threadAdder = new ThreadAdder(list, size);
    ThreadRemover threadRemover = new ThreadRemover(list);




    threadAdder.add(123);
    threadAdder.add(12);
    threadAdder.add(1224);
    threadAdder.add(12232131);

    threadRemover.remove();
    threadRemover.remove();
    threadRemover.remove();


  }
}

