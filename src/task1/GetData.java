package task1;
import java.text.DateFormat;

import java.util.Date;
import java.util.Locale;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class GetData extends Thread {

  public void run(){

    Date rightNow;
    Locale currentLocate;
    DateFormat timeFormatter;
    DateFormat dateFormatter;
    String timeOutput;
    String dataOutput;

    for (int i = 0 ; i <= 10; i++){

      rightNow = new Date();

      currentLocate = new Locale("bg");

      timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocate);

      dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT,currentLocate);

      timeOutput = timeFormatter.format(rightNow);
      dataOutput = dateFormatter.format(rightNow);

      System.out.println(timeOutput);
      System.out.println(dataOutput);
      System.out.println();

      try{
        Thread.sleep(2000);
      }catch (InterruptedException e){

      }
    }
  }



}
