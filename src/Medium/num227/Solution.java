package Medium.num227;

import java.util.Stack;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "3+5 / 2";
    System.out.println(solution.calculate(s));
  }

  public int calculate(String s) {
    int n = s.length();
    int i = 0;
    Stack<Integer> nums = new Stack<>();
    Stack<Character> opts = new Stack<>();
    while (i < n) {
      if (s.charAt(i) == ' ') {
        i++;
      } else if (Character.isDigit(s.charAt(i))) {
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
          num = num * 10 + s.charAt(i) - 48;
          i++;
        }
        if (!opts.empty()) {
          char c = opts.peek();
          if (c == '*' || c == '/') {
            opts.pop();
            int num1 = nums.pop();
            int res = 0;
            if (c == '*') {
              res = num1 * num;
            } else {
              res = num1 / num;
            }
            nums.push(res);
          } else {
            if (c == '+') {
              nums.push(num);
            } else {
              nums.push(-num);
            }
          }
        } else {
          nums.push(num);
        }
      } else {
        opts.push(s.charAt(i));
        i++;
      }
    }
    int ret = 0;
    while (!nums.empty()) {
      ret += nums.pop();
    }
    return ret;
  }
}
