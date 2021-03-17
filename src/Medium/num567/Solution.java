package Medium.num567;

import java.util.HashMap;

public class Solution {
  public static void main(String[] args) {
    String s1 = "hello";
    String s2 = "ooolleoooleh";
    Solution solution = new Solution();
    System.out.println(solution.checkInclusion(s1, s2));
    ;
  }

  // 思路  一个needs记录要找的字符串 一个Windows记录窗口里有的字符串
  // matches记录匹配上的  如果相等则返回true 不等继续右移窗口，直到到了字符串末尾
  public boolean checkInclusion(String s1, String s2) {
    if (s2 == null && s1 == null) {
      return true;
    }
    if (s2 == null) {
      return false;
    }
    if (s2.length() < s1.length()) {
      return false;
    }
    char[] chars1 = s1.toCharArray();
    char[] chars2 = s2.toCharArray();
    HashMap<Character, Integer> needs = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();
    for (char c : chars1) {
      needs.merge(c, 1, Integer::sum);
    }
    int left = 0;
    int right = 0;
    int matches = 0;
    while (right < chars2.length) {
      if (needs.containsKey(chars2[right])) {
        Integer count = window.merge(chars2[right], 1, Integer::sum);
        if (count.equals(needs.get(chars2[right]))) {
          matches++;
        }
      }
      right++;
      while (matches == needs.size()) {
        if (right - left == chars1.length) {
          return true;
        }
        if (needs.containsKey(chars2[left])) {
          Integer cur = window.merge(chars2[left], 1, (v1, v2) -> v1 - v2);
          if (cur < needs.get(chars2[left])) {
            matches--;
          }
        }
        left++;
      }
    }
    return false;
  }
}
