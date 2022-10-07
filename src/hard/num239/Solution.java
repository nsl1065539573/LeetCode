package hard.num239;

import java.util.PriorityQueue;

public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    // 大顶堆，存储当前窗口内的元素
    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
    for (int i = 0; i < k; i++) {
      queue.offer(new int[]{nums[i], i});
    }
    int len = nums.length;
    int[] res = new int[len - k + 1];
    res[0] = queue.peek()[0];
    for (int i = k; i < len; i++) {
      queue.offer(new int[]{nums[i], i});
      while (queue.peek()[1] < i - k + 1) {
        queue.poll();
      }
      res[i - k + 1] = queue.peek()[0];
    }
    return res;
  }
}
