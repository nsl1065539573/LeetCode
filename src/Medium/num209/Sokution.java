package Medium.num209;

public class Sokution {

  public static void main(String[] args) {
    int[] nums = {1, 4, 4};

  }

  public int minSubArrayLen(int s, int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int left = 0;
    int sum = 0;
    int right = 0;
    int ans = Integer.MAX_VALUE;
    while (right < nums.length) {
      sum += nums[right++];
      while (sum >= s) {
        ans = Math.min(ans, right - left);
        sum -= nums[left++];
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}
