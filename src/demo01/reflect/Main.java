package demo01.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
  public static void main(String[] args) throws ClassNotFoundException {
    Person person = new Student();
    Class clazz = Class.forName("demo01.reflect.Student");
    Method[] methods = clazz.getDeclaredMethods();
    for (Method m:
         methods) {
      System.out.println(m.toString());
    }
    Field[] fields = clazz.getDeclaredFields();
    for (Field f:
         fields) {
      System.out.println(f.toString());
    }
  }
}
