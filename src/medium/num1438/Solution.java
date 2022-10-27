package medium.num1438;

import java.util.TreeMap;

/**
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 **/
public class Solution {
  public static void main(String[] args) {
    int[] arr = new int[] {4,2,2,2,4,4,2,2};
    Solution solution = new Solution();
    System.out.println(solution.longestSubarray(arr, 0));
  }

  public int longestSubarray(int[] nums, int limit) {
    TreeMap<Integer, Integer> window = new TreeMap<>();
    int left = 0;
    int right = 0;
    int res = 0;
    while (right < nums.length) {
      window.merge(nums[right], 1, Integer::sum);
      right++;
      while (window.size() > 1 && window.lastKey() - window.firstKey() > limit) {
        int remainder = window.get(nums[left]);
        if (remainder == 1) {
          window.remove(nums[left]);
        } else {
          window.put(nums[left], remainder - 1);
        }
        left++;
      }
      res = Math.max(res, right - left);
    }
    return res;
  }
}
