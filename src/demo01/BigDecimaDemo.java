package demo01;

import java.math.BigDecimal;

public class BigDecimaDemo {
  public static void main(String[] args) {
    BigDecimal b1 = BigDecimal.valueOf(38000);
    BigDecimal b2 = BigDecimal.valueOf(100);
    System.out.println(b1.divide(b2).equals(BigDecimal.valueOf(b1.intValue() / 100)));
  }
}
