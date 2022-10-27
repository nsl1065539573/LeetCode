package medium.num1438;

import java.util.*;

public class Solution {

  public int longestSubarray(int[] nums, int limit) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int left = 0;
    int right = 0;
    int res = 0;
    while (right < nums.length) {
      priorityQueue.offer(nums[right]);
      priorityQueue1.offer(nums[right]);
      right++;
      while (left < right) {
        int min = priorityQueue.peek();
        int max = priorityQueue1.peek();
        if (max - min > limit) {
          priorityQueue.remove(nums[left]);
          priorityQueue1.remove(nums[left]);
          left++;
        } else {
          break;
        }
      }
      res = Math.max(res, right - left);
    }
    return res;
  }


  public int largestRectangleArea(int[] heights) {
    int len = heights.length;
    if (len == 0) {
      return 0;
    }

    if (len == 1) {
      return heights[0];
    }

    int res = 0;

    int[] newHeights = new int[len + 2];
    newHeights[0] = 0;
    System.arraycopy(heights, 0, newHeights, 1, len);
    newHeights[len + 1] = 0;
    len += 2;
    heights = newHeights;

    Deque<Integer> stack = new ArrayDeque<>(len);
    // 先放入哨兵，在循环里就不用做非空判断
    stack.addLast(0);

    for (int i = 1; i < len; i++) {
      while (heights[i] < heights[stack.peekLast()]) {
        int curHeight = heights[stack.pollLast()];
        int curWidth = i - stack.peekLast() - 1;
        res = Math.max(res, curHeight * curWidth);
      }
      stack.addLast(i);
    }
    return res;
  }

  public static void main(String[] args) {
     int[] heights = {2, 1, 5, 6, 2, 3};
//    int[] heights = {1, 1};
    Solution solution = new Solution();
    int res = solution.largestRectangleArea(heights);
    System.out.println(res);
  }
}
