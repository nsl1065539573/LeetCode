package Easy.num232;

import java.util.Stack;

public class MyQueue {
  private Stack<Integer> stackA;
  private Stack<Integer> stackB;

  /** Initialize your data structure here. */
  public MyQueue() {
    stackA = new Stack<>();
    stackB = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    stackA.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if (!stackB.empty()) {
      return stackB.pop();
    } else {
      while (!stackA.empty()) {
        stackB.push(stackA.pop());
      }
    }
    return stackB.pop();
  }

  /** Get the front element. */
  public int peek() {
    if (!stackB.empty()) {
      return stackB.peek();
    } else {
      while (!stackA.empty()) {
        stackB.push(stackA.pop());
      }
    }
    return stackB.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stackA.empty() && stackB.empty();
  }
}
