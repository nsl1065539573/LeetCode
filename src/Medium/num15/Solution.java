package Medium.num15;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    int[] arr = {1,2,-2,-1};
    Solution solution = new Solution();
    List res = solution.threeSum(arr);
    System.out.println(res.toString());
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    if (nums.length < 3) {
      return res;
    }
    Arrays.sort(nums);
    HashMap<Integer, Integer> map= new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        List<List<Integer>> ret = twoSum(nums, i, -nums[i]);
        for (List<Integer> list:
            ret) {
          list.add(nums[i]);
          res.add(list);
        }
        map.put(nums[i], 0);
      }
    }
    return res;
  }

  public List<List<Integer>> twoSum(int[] nums, int visited, int target) {
    List<List<Integer>> res = new LinkedList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = visited + 1; i < nums.length; i++) {
      int temp = nums[i];
      if (map.containsKey(target - nums[i])) {
        List<Integer> list = new LinkedList<>();
        list.add(target - nums[i]);
        list.add(nums[i]);
        res.add(list);
        while (i < nums.length - 1 && nums[i + 1] == temp) {
          i++;
        }
      } else {
        map.put(nums[i], i);
      }
    }
    return res;
  }
}
