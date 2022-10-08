package medium.offer31;

import java.util.Stack;

/**
 * @Author: nansongling
 * @Date: 2022/10/8 6:55 PM
 **/
public class Solution {
  public static void main(String[] args) {
    int[] pushed = {2, 1, 0};
    int[] poped = {1, 2, 0};
    Solution solution = new Solution();
    System.out.println(solution.validateStackSequences(pushed, poped));
  }

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int index = 0;
    for (int i = 0; i < pushed.length; i++) {
      if (pushed[i] == popped[index]) {
        index++;
        continue;
      }
      while (!stack.isEmpty() && stack.peek() == popped[index]) {
        stack.pop();
        index++;
      }
      stack.push(pushed[i]);
    }
    for (;index < popped.length; index++) {
      int top = stack.pop();
      if (top != popped[index]) {
        return false;
      }
    }
    return true;
  }
}
