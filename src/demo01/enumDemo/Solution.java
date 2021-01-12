package demo01.enumDemo;

public class Solution {
  public static void main(String[] args) {
    System.out.println("DEMO1".equals(Demo.DEMO1.toString()));
  }
}

enum Demo {
  DEMO1("1", "AAA"),
  DEMO2("2", "BBB");

  String code;
  String desc;

  Demo(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
