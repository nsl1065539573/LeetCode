package demo01.innerClass;

public class Test {
  public static void main(String[] args) throws InterruptedException {
    Student student = new Student();
    Thread.sleep(10000);
    student.getInnerClassTime();
  }
}
