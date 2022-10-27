package medium.num904;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] test = new int[]{1,2,1};
    System.out.println(solution.totalFruit(test));
  }

  public int totalFruit(int[] fruits) {
    // 滑动窗口？ 先向右加 待窗口里的元素个数大于二 算出窗口大小，向左收缩
    if (fruits.length < 3) {
      return fruits.length;
    }
    int res = 0;
    Map<Integer, Integer> window = new HashMap<>();
    int left = 0;
    for (int i = 0; i < fruits.length; i++) {
      window.merge(fruits[i], 1, Integer::sum);
      if (window.size() <= 2) {
        res = Math.max(res, i - left + 1);
      }
      while (window.size() > 2) {
        int l = window.get(fruits[left]);
        if (l == 1) {
          window.remove(fruits[left]);
        } else {
          window.put(fruits[left], l - 1);
        }
        left++;
      }
    }
    return res;
  }
}
