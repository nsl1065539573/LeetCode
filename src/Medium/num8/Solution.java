package Medium.num8;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int res = solution.myAtoi("3.14159");
    System.out.println("res is " + res);
  }

  public int myAtoi(String s) {
    // step1: 去掉字符串前面的空白字符
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ' ') {
        s = s.substring(i);
        break;
      }
    }
    if ("".equals(s)) {
      return 0;
    }
    // step2: 判断得到的第一个字符，非'-'或者'+'则返回0
    if (s.charAt(0) != '-' && s.charAt(0) != '+' && (s.charAt(0) < 48 || s.charAt(0) > 57)) {
      return 0;
    }
    boolean isPositive = '-' != s.charAt(0);
    // step3: 得到尽可能多的数字
    int i = 0;
    if (s.charAt(0) == '+' || s.charAt(0) == '-') {
      i = 1;
    }
    StringBuilder sb = new StringBuilder();
    for (int j = i; j < s.length(); j++) {
      if (s.charAt(j) > 47 && s.charAt(j) < 58) {
        sb.append(s.charAt(j));
      } else {
        break;
      }
//      if ((s.charAt(j) < 48 || s.charAt(j) > 57) || j == s.length() - 1) {
//        s = s.substring(i, j + 1);
//        break;
//      }
    }
    s = sb.toString();
//    s = new StringBuilder(s).reverse().toString();
    // step4: 反转数字部分，得到数字
    int res = 0;
    for (int j = 0; j < s.length(); j++) {
      int temp = s.charAt(j) - '0';
      if (res > (Integer.MAX_VALUE - temp) / 10) {
        return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      res = res * 10 + temp;
    }
    return isPositive ? res : -1 * res;
    // step5: 判断是否已经越界
  }
}
