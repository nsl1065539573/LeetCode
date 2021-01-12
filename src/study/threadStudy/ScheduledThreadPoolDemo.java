package study.threadStudy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
  public static void main(String[] args) {
    ScheduledExecutorService scheduledExecutorService =
        Executors.newScheduledThreadPool(3);
    scheduledExecutorService.schedule(new Runnable() {
      @Override
      public void run() {
        System.out.println("delay 3 seconds execu.");
      }
    }, 3, TimeUnit.SECONDS);
    scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        System.out.println("delay 1 seconds,execute every 3 seconds");
      }
    }, 1, 3, TimeUnit.SECONDS);
  }
}
