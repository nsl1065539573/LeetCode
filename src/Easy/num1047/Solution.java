package Easy.num1047;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
  public String removeDuplicates(String S) {
    Stack<Character> stack = new Stack<>();
    char[] chars = S.toCharArray();
    for (char c: chars) {
      if (stack.size() > 0 && stack.peek() == c) {
        while (stack.size() > 0 && stack.peek() == c) {
          stack.pop();
        }
      } else {
        stack.push(c);
      }
    }
    char[] res = new char[stack.size()];
    for (int i = res.length - 1; i >= 0; i--) {
      res[i] = stack.pop();
    }
    return new String(res);
  }
}
