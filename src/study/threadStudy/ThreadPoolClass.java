package study.threadStudy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolClass {
  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 5; i++) {
      threadPool.execute(new Runnable() {
        @Override
        public void run() {
          System.out.println("execute thread:::" + Thread.currentThread().getName());
        }
      });
    }
  }
}
