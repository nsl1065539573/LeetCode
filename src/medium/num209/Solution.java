package medium.num209;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 滑动窗口
 **/
public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = new int[] {2,3,1,2,4,3};
    System.out.println(solution.minSubArrayLen(7, nums));
  }

  public int minSubArrayLen(int target, int[] nums) {
    int left = 0;
    int right = 0;
    int sum = 0;
    int res = nums.length;
    boolean grateThanTarget = false;
    while (right < nums.length) {
      sum += nums[right];
      right++;
      while (sum >= target) {
        res = Math.min(res, right - left);
        sum -= nums[left];
        left++;
        grateThanTarget = true;
      }
    }
    if (grateThanTarget) {
      return res;
    } else {
      return 0;
    }
  }
}
