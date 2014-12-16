package test.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

      ExecutorService executor = Executors.newFixedThreadPool(1);

      for (int i = 0; i < 5; i++) {
        executor.submit(new ThreadPool(i));
      }


      executor.shutdown();


      System.out.println("All tasks submitted.");

      try {
        executor.awaitTermination(10, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
      }

      System.out.println("All tasks completed.");
    }
  }

