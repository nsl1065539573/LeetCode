package Easy.num665;

// 和前面的比还有和后面的比  如果比前面的小 也比后面的小，后面的再和前面的比一下，
public class Solution {
  public boolean checkPossibility(int[] nums) {
    int times = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        times++;
        if (times > 1) {
          return false;
        }
        if (i == 1 || nums[i] >= nums[i - 2]) {
          nums[i - 1] = nums[i];
        } else {
          nums[i] = nums[i - 1];
        }
      }
    }
    return true;
  }
}
