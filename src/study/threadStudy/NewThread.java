package study.threadStudy;

// step1: 继承Thread类
public class NewThread extends Thread{
  // step2: 重写run方法
  @Override
  public void run() {
    System.out.println("create a thread by extends Thread");
  }

  public static void main(String[] args) {
    // step3: 实例化对象并且执行run方法
    NewThread newThread = new NewThread();
    newThread.start();
  }
}

