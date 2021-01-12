package study.threadStudy;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

// step1: 实现Callable接口
public class CallableThread implements Callable<String> {
  private String name;

  public CallableThread(String name) {
    this.name = name;
  }

  // step2: 实现call方法
  @Override
  public String call() throws Exception {
    return this.name;
  }

  public static void main(String[] args) {
    // step3: 实现一个大小为5的线程池
    ExecutorService pool = Executors.newFixedThreadPool(5);
    // step4: 创建Future的list
    List<Future> list = new LinkedList<>();
    for (int i = 0; i < 5; i++) {
      // step5: 创建有返回值的Callable实例
      CallableThread c = new CallableThread(i + " ");
      // step6: 使用Future记录结果并且加到集合中
      Future future = pool.submit(c);
      list.add(future);
    }
    // step7: 关闭线程池，等待线程执行结束
    pool.shutdown();
    // step8： 可以通过Future的get方法获取到返回值
    for (Future future : list) {
      try {
        System.out.println("get the result from callable thread:" + future.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
  }
}
