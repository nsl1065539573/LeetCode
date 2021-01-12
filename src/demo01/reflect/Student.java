package demo01.reflect;

public class Student implements Person{
  @Override
  public void sleep() {
    System.out.println("sleeping...");
  }

  @Override
  public void eat() {
    System.out.println("eat chicken...");
  }

  public void study() {
    System.out.println("studying...");
  }
}
