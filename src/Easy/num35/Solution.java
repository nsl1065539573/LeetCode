package Easy.num35;

public class Solution {
  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    int mid = (left + right) / 2;
    while (left < right) {
      if (nums[mid] < target) {
        left = mid;
      } else if (nums[mid] > target) {
        right = mid;
      } else {
        return mid;
      }
      mid = (left + right) / 2;
    }
    if (nums[mid] > target) {
      if (mid > 0) {
        return mid - 1;
      } else {
        return 0;
      }
    } else {
      return mid + 1;
    }
  }
}
