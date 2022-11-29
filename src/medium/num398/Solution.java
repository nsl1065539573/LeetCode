package medium.num398;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Random random = new Random();
    for (int i = 0; i < 1000; i++) {
      int temp = random.nextInt(10);
      if (temp == 10) {
        System.out.println("10");
      }
      if (temp == 0) {
        System.out.println("0");
      }
    }
  }

  private Map<Integer, List<Integer>> map;

  public Solution(int[] nums) {
    this.map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        map.get(nums[i]).add(i);
      } else {
        map.put(nums[i], new ArrayList<>());
        map.get(nums[i]).add(i);
      }
    }
  }

  public int pick(int target) {
    List<Integer> list = this.map.get(target);
    Random random = new Random();
    return list.get(random.nextInt(list.size()));
  }
}
