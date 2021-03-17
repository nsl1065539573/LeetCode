package Hard.num239;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[]  arr = {4,-2};
    System.out.println(Arrays.toString(solution.maxSlidingWindow(arr, 2)));
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    for (int i = 0; i < k; i++) {
      queue.offer(nums[i]);
    }
    int[] res = new int[nums.length - k + 1];
    int left = 0;
    int right = k;
    int i = 0;
    while (right <= nums.length) {
      res[i] = queue.peek();
      i++;
      queue.remove(nums[left]);
      left++;
      if (right < nums.length) {
        queue.offer(nums[right]);
      }
      right++;
    }
    return res;
  }
}
