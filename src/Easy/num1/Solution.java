package Easy.num1;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr = {3, 3};
    int[] res = solution.twoSum(arr, 6);
    System.out.println(Arrays.toString(res));
  }

  public int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        res[0] = map.get(target - nums[i]);
        res[1] = i;
        return res;
      } else {
        map.put(nums[i], i);
      }
    }
    return res;
  }
}
