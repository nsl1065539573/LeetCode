package Easy.num643;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {1,12,-5,-6,50,3};
    System.out.println(solution.findMaxAverage(nums, 4));
  }

  public double findMaxAverage(int[] nums, int k) {
    int sumK = 0;
    for (int i = 0; i < k; i++) {
      sumK = nums[i] + sumK;
    }
    double maxAve = sumK * 1.0 / k;
    int left = 0;
    for (int right = k; right < nums.length; right++) {
      sumK = sumK - nums[left];
      left++;
      sumK = sumK + nums[right];
      double curAve = sumK * 1.0 / k;
      if (curAve > maxAve) {
        maxAve = curAve;
      }
    }
    return maxAve;
  }
}
