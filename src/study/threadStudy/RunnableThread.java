package study.threadStudy;

// step1: 实现Runnable接口
public class RunnableThread implements Runnable{
  // step2: 重写run方法
  @Override
  public void run() {
    System.out.println("create a thread implements Runnable");
  }

  public static void main(String[] args) {
    // step3: 实例化该类
    RunnableThread runnableThread = new RunnableThread();
    // step4: 将该类以参数形式传入Thread类的构造器中
    Thread thread = new Thread(runnableThread);
    // step5: 执行Thread的start方法
    thread.start();
  }
}
