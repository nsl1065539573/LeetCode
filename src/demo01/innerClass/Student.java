package demo01.innerClass;

public class Student {
  private static class InnerClass {
    private static final Long TIME = System.currentTimeMillis();
  }

  static {
    System.out.println("Student 正在加载..." + System.currentTimeMillis());
  }

  public void getInnerClassTime() {
    System.out.println(InnerClass.TIME);
  }
}
