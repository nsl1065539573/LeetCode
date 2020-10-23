package Easy.num844;

import java.util.Stack;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char item = S.charAt(i);
            if (item == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else
                stack1.push(item);
        }
        for (int i = 0; i < T.length(); i++) {
            char item = T.charAt(i);
            if (item == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else
                stack2.push(item);
        }
        return stack1.equals(stack2);
    }
}
