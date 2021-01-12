package study.threadStudy;

public class JoinDemo {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("子线程开始运行");
    ChildThreadDemo thread = new ChildThreadDemo();
    thread.start();
    thread.join();
    System.out.println("子线程join结束");
  }
}

class ChildThreadDemo extends Thread {
  @Override
  public void run() {
    System.out.println("子线程开始执行");
  }
}