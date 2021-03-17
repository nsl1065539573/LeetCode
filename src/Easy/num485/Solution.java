package Easy.num485;

public class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int res = 0;
    int left = 0;
    int right = 0;
    while (right < nums.length) {
      if (nums[right] != 0) {
        right++;
      } else {
        res = Math.max(res, right - left);
        right++;
        left = right;
      }
    }
    res = Math.max(res, right - left);
    return res;
  }
}
