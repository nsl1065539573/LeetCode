package Easy.num830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    List res = solution.largeGroupPositions("abbxxxxzzy");
    System.out.println(res.toString());
  }

  public List<List<Integer>> largeGroupPositions(String s) {
//    List<List<Integer>> res = new LinkedList<>();
//    // step1: 如果s为空或者长度小于3 直接返回null
//    if (s == null || "".equals(s) || s.length() < 3) {
//      return res;
//    }
//    // step2: 双指针向后遍历，如果s.charAt[right] == s.charAt(left) right ++
//    int left = 0;
//    int right = 0;
//    while (right < s.length() && left < s.length()) {
//      if (s.charAt(left) != s.charAt(right)) {
//        if (right - left > 2) {
//          List<Integer> list = new ArrayList<>(2);
//          list.add(left);
//          list.add(right - 1);
//          res.add(list);
//        }
//        left = right;
//      } else {
//        if (right == s.length() - 1 && right - left > 1) {
//          List<Integer> list = new ArrayList<>(2);
//          list.add(left);
//          list.add(right);
//          res.add(list);
//        }
//      }
//      right++;
//    }
//    // 否则 left = right; right ++
//    return res;
    List<List<Integer>> res = new LinkedList<>();
    if (s == null || "".equals(s) || s.length() < 3) {
      return res;
    }
    int count = 1;
    for (int i = 0; i < s.length(); i++) {
      if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
        if (count > 2) {
          ArrayList<Integer> list = new ArrayList<>(2);
          list.add(i - count + 1);
          list.add(i);
          res.add(list);
        }
        count = 1;
      } else {
        count++;
      }
    }
    return res;
  }
}
