package Hard.num224;

import java.util.Stack;

public class Solution {
  public static void main(String[] args) {
    String s = "2147483647";
    Solution solution = new Solution();
    System.out.println(solution.calculate(s));
  }
  public int calculate(String s) {
    Stack<Integer> operationStack = new Stack<>();
    operationStack.push(1);
    int sign = 1;
    int res = 0;
    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (c == ' ') {
        i++;
      } else if (c == '+') {
        sign = operationStack.peek();
        i++;
      } else if (c == '-') {
        i++;
        sign = -operationStack.peek();
      } else if (c == '(') {
        i++;
        operationStack.push(sign);
      } else if (c == ')') {
        i++;
        operationStack.pop();
      } else {
        long num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
          num = 10 * num + s.charAt(i) - 48;
          i++;
        }
        res += num * sign;
      }
    }
    return res;
  }
}
