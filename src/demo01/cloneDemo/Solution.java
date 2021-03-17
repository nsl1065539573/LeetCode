package demo01.cloneDemo;

import java.math.BigDecimal;

public class Solution {
  public static void main(String[] args) throws CloneNotSupportedException {
    A a = new A(new BigDecimal(5000));
    A b = (A) a.clone();
  }
}

class A {
  BigDecimal credit;
  public A(BigDecimal credit) {
    this.credit = credit;
  }

  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}