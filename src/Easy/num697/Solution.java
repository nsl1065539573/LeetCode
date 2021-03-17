package Easy.num697;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("1", 1);
    map.remove("1");
    System.out.println(map.containsKey("1"));
  }

  public int findShortestSubArray(int[] nums) {
    HashMap<Integer, int[]> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        map.get(nums[i])[0]++;
        map.get(nums[i])[2] = i;
      } else {
        map.put(nums[i], new int[]{1, i, i});
      }
    }
    int maxNum = 0;
    int res = 0;
    for (Integer k : map.keySet()) {
      if (map.get(k)[0] > maxNum) {
        maxNum = map.get(k)[0];
        res = map.get(k)[2] - map.get(k)[1];
      } else if (map.get(k)[0] == maxNum) {
        if (res > map.get(k)[2] - map.get(k)[1]) {
          res = map.get(k)[2] - map.get(k)[1];
        }
      }
    }
    return res;
  }
}
