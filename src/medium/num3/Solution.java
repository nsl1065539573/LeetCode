package medium.num3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "aaaaav";
    System.out.println(solution.lengthOfLongestSubstring(s));
  }

  public int lengthOfLongestSubstring(String s) {
    // 滑动窗口，HashMap记录窗口里已有的
    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int right = 0;
    int res = 0;
    while (right < s.length()) {
      char c = s.charAt(right);
      right++;
      map.merge(c, 1, Integer::sum);
      while (left < s.length() && map.get(c) > 1) {
        map.put(s.charAt(left), map.get(s.charAt(left))-1);
        left++;
      }
      res = Math.max(res, right - left);
    }
    return res;
  }
}
